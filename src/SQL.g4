grammar SQL;

fragment LETTER:               [a-z] | [A-Z];
fragment DIGIT:                [0-9];

ID:                   LETTER (LETTER | DIGIT | '_')*;
NUM:                  DIGIT (DIGIT)* ;
STRING:                 '\"' (LETTER)* '\"';
REAL:					(DIGIT)+ '.' (DIGIT)+;

queries:            query (';')? #singleQ
                    |query (';' query)*#mulQ;

query: 			 databaseStm #dataStm
				| tableStm #tblStm;


databaseStm: 	'CREATE' 'DATABASE' ID #createDB
                | 'ALTER' 'DATABASE' ID 'RENAME' 'TO' ID #renameDB
                | 'DROP' 'DATABASE' ID #dropDB
                | 'SHOW' 'DATABASES' #showDB
                | 'USE' 'DATABASE' ID #useDB;

tableStm:        alterStm
                |createStm
                |deleteStm
                |dropStm
                |insertStm
                |selectStm
                |updateStm
                |showStm;             
                
//Tablas Stm
showStm:        'SHOW' 'TABLES' #showTbl
                |'SHOW' 'COLUMNS' 'FROM' ID #showCol;  

alterStm:       'ALTER' 'TABLE' ID 'RENAME' 'TO' ID #renameTbl
                |'ALTER' 'TABLE' ID 'ADD'  'COLUMN' ID type ('NOT' 'NULL')?  (constraint)? #addCol
                | 'ALTER' 'TABLE' ID 'ADD'  constraint  #addCon
                | 'ALTER' 'TABLE' ID 'DROP' 'COLUMN' ID #dropCol
                | 'ALTER' 'TABLE' ID 'DROP' 'CONSTRAINT' ID #dropCon;

createStm:       'CREATE' 'TABLE' ID '(' (createList)? ')'  ;


createList:     createDef ',' createList #singleDef
                | createDef #mulDef;

createDef:      fieldDef 
                | constraint;

fieldDef: ID type (notNull='NOT' 'NULL')? (ref='REFERENCES' refTable=ID '(' refID=ID ')')?;


type:   'INT'
		|'FLOAT'
        |'DATE'
		|'CHAR' '(' NUM ')';




constraint: 'CONSTRAINT' ID constraintType;

constraintType: 'PRIMARY' 'KEY' '(' idList ')' #pKey
                    | 'FOREIGN' 'KEY' '(' idList ')' 'REFERENCES' ID '(' idList ')' #fKey
                    | 'CHECK' '(' expression ')' #check;

dropStm : 'DROP' 'TABLE' ID;


//Update database

insertStm: 'INSERT' 'INTO' ID ('(' idList ')')? 'VALUES' '(' (exprList)? ')';

updateStm: 'UPDATE' ID 'SET' assignList whereClause;

assignList: ID '=' expression ',' assignList #singleAss
                  | ID '=' expression #mulAss;

deleteStm: 	'DELETE' 'FROM' ID whereClause;


//Select Statement

selectStm: 'SELECT' columnas=columns  fromClause whereClause orderClause;

columns:  '*' #selectAll
                  |  columnList #selectCol;

columnList:    columnItem ',' columnList #singleCol
                  | columnItem #mulCol;


columnItem: columnSource #column
                  | columnSource as='AS' ID #columnAs;
                  
columnSource: aggregate  #colAgg
                  | ID ('.' ID)? #refTbl  ;      


aggregate:		  'COUNT'  '(' '*' ')' #countAll
                  | 'COUNT'  '(' expression ')' #countExp
                  | 'AVG'    '(' expression ')' #avg
                  | 'MIN'    '(' expression ')' #min
                  | 'MAX'   '(' expression ')' #max
                  | 'SUM'    '(' expression ')' #sum;


fromClause:  'FROM' idListFrom;


whereClause: 'WHERE' expression
                  | ;

orderClause: 'ORDER' 'BY' orderList
                  |  ;

orderList:   ID ('.' ID)? orderType ',' orderList #singleOrder
                  | ID('.' ID)? orderType #mulOrder;

orderType:			'ASC' #asc
                  | 'DESC' #desc
                  |	 #nada;


//Expressions

expression: andExp 'OR' expression 
                | andExp;

andExp: 		notExp 'AND' andExp
                | notExp;

notExp:		not='NOT' predExp
                | predExp;

predExp: 	
                
                 value 'IS' 'NOT' 'NULL' #notNull
                | value 'IS' 'NULL' #isNull
                | addExp 'LIKE' STRING #like
                | addExp '='  addExp #equals
                | addExp '!=' addExp #notEquals
                | addExp '>'  addExp #greater
                | addExp '>=' addExp #greaterEqual
                | addExp '<'  addExp #lower
                | addExp '<=' addExp #lowerEqual
                | addExp #exp; 

addExp:           multExp '+' addExp #suma
                | multExp '-' addExp #resta
                | multExp #emptyAdd;

multExp:	 negateExp '*' multExp #mult
                |negateExp '/' multExp #div
                | negateExp #emptyMult;

negateExp:		 '-' value #negate
                | value #notNegate;
        
value:           '(' expression ')' 
                | ID ('.' ID)?
                | NUM
                | REAL
                | STRING
                | 'NULL';


exprList:		expression ',' exprList #mulExp
               | expression #singleExp;

idListFrom : idMember (idMember)? ',' idListFrom #mulTable
                | idMember (idMember)? #singleTable;

idList : idMember ',' idList #mulMember
                | idMember #singleMember;

idMember:  ID;

//Tokens
COMMENT:              '//' ~('\n' | '\r')*;
WS:                   ([ \t\r\n]+ | COMMENT) -> skip;
