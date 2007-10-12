package org.talend.designer.codegen.translators.databases.as400;

import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.MetadataTalendType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

public class TAS400OutputBeginJava
{
  protected static String nl;
  public static synchronized TAS400OutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAS400OutputBeginJava result = new TAS400OutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "    int keyCount_";
  protected final String TEXT_5 = " = ";
  protected final String TEXT_6 = ";" + NL + "    if(keyCount_";
  protected final String TEXT_7 = " < 1)" + NL + "    {" + NL + "    \tthrow new Exception(\"For update or delete, Schema must have a key\");" + NL + "    }";
  protected final String TEXT_8 = NL + NL + "int nb_line_";
  protected final String TEXT_9 = " = 0;" + NL + "int nb_line_update_";
  protected final String TEXT_10 = " = 0;" + NL + "int nb_line_inserted_";
  protected final String TEXT_11 = " = 0;" + NL + "int nb_line_deleted_";
  protected final String TEXT_12 = " = 0;" + NL + "" + NL + "int deletedCount_";
  protected final String TEXT_13 = "=0;" + NL + "int updatedCount_";
  protected final String TEXT_14 = "=0;" + NL + "int insertedCount_";
  protected final String TEXT_15 = "=0;" + NL + "" + NL + "boolean whetherReject_";
  protected final String TEXT_16 = " = false;" + NL + "" + NL + "java.lang.Class.forName(\"com.ibm.as400.access.AS400JDBCDriver\");" + NL + "" + NL + "String url_";
  protected final String TEXT_17 = " = \"jdbc:as400://\" + ";
  protected final String TEXT_18 = " + \"/\" + ";
  protected final String TEXT_19 = " + \";prompt=false\"; " + NL + "" + NL + "String dbUser_";
  protected final String TEXT_20 = " = ";
  protected final String TEXT_21 = ";" + NL + "String dbPwd_";
  protected final String TEXT_22 = " = ";
  protected final String TEXT_23 = ";" + NL + "" + NL + "java.sql.Connection conn_";
  protected final String TEXT_24 = " = java.sql.DriverManager.getConnection(url_";
  protected final String TEXT_25 = ",dbUser_";
  protected final String TEXT_26 = ",dbPwd_";
  protected final String TEXT_27 = ");" + NL;
  protected final String TEXT_28 = NL + "java.sql.Statement stmtClear_";
  protected final String TEXT_29 = " = conn_";
  protected final String TEXT_30 = ".createStatement();" + NL + "deletedCount_";
  protected final String TEXT_31 = " = deletedCount_";
  protected final String TEXT_32 = " + stmtClear_";
  protected final String TEXT_33 = ".executeUpdate(\"delete from \\\"\" + ";
  protected final String TEXT_34 = "+\"\\\"\");";
  protected final String TEXT_35 = NL;
  protected final String TEXT_36 = NL + NL + "java.sql.PreparedStatement pstmtInsert_";
  protected final String TEXT_37 = " =null;" + NL + "" + NL + "java.sql.PreparedStatement pstmtUpdate_";
  protected final String TEXT_38 = " =null;" + NL + "" + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_39 = " =null;" + NL;
  protected final String TEXT_40 = NL + NL + "java.sql.PreparedStatement pstmt_";
  protected final String TEXT_41 = " =null;" + NL + "\t";
  protected final String TEXT_42 = "\t" + NL + "\t" + NL + "\t\tpstmt_";
  protected final String TEXT_43 = " = conn_";
  protected final String TEXT_44 = ".prepareStatement(\"INSERT INTO \\\"\"+";
  protected final String TEXT_45 = "+\"\\\" (";
  protected final String TEXT_46 = ") VALUES (";
  protected final String TEXT_47 = ")\");" + NL + "" + NL + "\t";
  protected final String TEXT_48 = NL + "\t" + NL + "\t\tpstmt_";
  protected final String TEXT_49 = " = conn_";
  protected final String TEXT_50 = ".prepareStatement(\"UPDATE \\\"\"+";
  protected final String TEXT_51 = "+\"\\\" SET ";
  protected final String TEXT_52 = " WHERE ";
  protected final String TEXT_53 = "\");" + NL + "" + NL + "\t";
  protected final String TEXT_54 = NL + "\t\tpstmt_";
  protected final String TEXT_55 = " = conn_";
  protected final String TEXT_56 = ".prepareStatement(\"SELECT COUNT(1) FROM \\\"\" + ";
  protected final String TEXT_57 = " + \"\\\" WHERE ";
  protected final String TEXT_58 = "\");\t" + NL + "\t" + NL + "\t\tpstmtInsert_";
  protected final String TEXT_59 = " = conn_";
  protected final String TEXT_60 = ".prepareStatement(\"INSERT INTO \\\"\"+";
  protected final String TEXT_61 = "+\"\\\" (";
  protected final String TEXT_62 = ") VALUES (";
  protected final String TEXT_63 = ")\");" + NL + "" + NL + "\t\tpstmtUpdate_";
  protected final String TEXT_64 = " = conn_";
  protected final String TEXT_65 = ".prepareStatement(\"UPDATE \\\"\"+";
  protected final String TEXT_66 = "+\"\\\" SET ";
  protected final String TEXT_67 = " WHERE ";
  protected final String TEXT_68 = "\");" + NL + "" + NL + "\t";
  protected final String TEXT_69 = NL + "\t\tpstmtUpdate_";
  protected final String TEXT_70 = " = conn_";
  protected final String TEXT_71 = ".prepareStatement(\"UPDATE \\\"\"+";
  protected final String TEXT_72 = "+\"\\\" SET ";
  protected final String TEXT_73 = " WHERE ";
  protected final String TEXT_74 = "\");" + NL + "" + NL + "\t\tpstmtInsert_";
  protected final String TEXT_75 = " = conn_";
  protected final String TEXT_76 = ".prepareStatement(\"INSERT INTO \\\"\"+";
  protected final String TEXT_77 = "+\"\\\" (";
  protected final String TEXT_78 = ") VALUES (";
  protected final String TEXT_79 = ")\");" + NL + "\t\t" + NL + "\t";
  protected final String TEXT_80 = NL + "\t" + NL + "\t\tpstmt_";
  protected final String TEXT_81 = " = conn_";
  protected final String TEXT_82 = ".prepareStatement(\"DELETE  FROM \\\"\"+";
  protected final String TEXT_83 = "+\"\\\"\t WHERE ";
  protected final String TEXT_84 = "\");" + NL + "" + NL + "\t";
  protected final String TEXT_85 = NL + NL + "int commitEvery_";
  protected final String TEXT_86 = " = ";
  protected final String TEXT_87 = ";" + NL + "" + NL + "int commitCounter_";
  protected final String TEXT_88 = " = 0;" + NL + "" + NL + "conn_";
  protected final String TEXT_89 = ".setAutoCommit(false);";
  protected final String TEXT_90 = NL + NL + NL;
  protected final String TEXT_91 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	
	String cid = node.getUniqueName();
	
    List<Map<String, String>> addCols =
            (List<Map<String,String>>)ElementParameterParser.getObjectValue(
                node,"__ADD_COLS__" );
    
    
    String dbname= ElementParameterParser.getValue(node, "__DBNAME__");
        
    String dbhost = ElementParameterParser.getValue(node, "__HOST__");
    	
	String dbuser= ElementParameterParser.getValue(node, "__USER__");
	
	String dbpwd= ElementParameterParser.getValue(node, "__PASS__");
	
	String tableName = ElementParameterParser.getValue(node,"__TABLE__");
	
	String dataAction = ElementParameterParser.getValue(node,"__DATA_ACTION__");
	
	String tableAction = ElementParameterParser.getValue(node,"__CLEAR_TABLE__");
	
	String commitEvery = ElementParameterParser.getValue(node, "__COMMIT_EVERY__");


    stringBuffer.append(TEXT_2);
    
List<IMetadataColumn> columnList = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if(metadatas !=null && metadatas.size()>0){
	IMetadataTable metadata = metadatas.get(0);
	if(metadata != null){
		columnList = metadata.getListColumns();
	}
}

    stringBuffer.append(TEXT_3);
    
if(!dataAction.equals("INSERT"))
{
    int keyCount = 0;
    for(IMetadataColumn column:columnList)
    {
    	if(column.isKey())
    	{
    		keyCount++;
    	}
    }
    
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(keyCount);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    
}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
if(tableAction.equals("true"))
{

    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_34);
    	
}

    stringBuffer.append(TEXT_35);
    if(dataAction.equals("INSERT_OR_UPDATE")||dataAction.equals("UPDATE_OR_INSERT")){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    }else{
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    
}

if(columnList != null && columnList.size()>0){

class Column{

	IMetadataColumn column;
	
	String name;
	
	String DBname;
	
	String sqlStmt;
	
	String value;
	
	boolean addCol;
	
	List<Column> replacement = new ArrayList<Column>();
	
	public Column(String colName,String sqlStmt,boolean addCol){
		this.column = null;
		this.name=colName;
		this.DBname = colName;
		this.sqlStmt = sqlStmt;
		this.value = "?";
		this.addCol =addCol;
	}
	
	public Column(IMetadataColumn column){
		this.column = column;
		this.name = column.getLabel();
		this.sqlStmt = "=?";
		this.value = "?";
		this.addCol =false;
		this.DBname=column.getOriginalDbColumnName();
	}
	
	public boolean isReplaced(){
		return replacement.size()>0;
	}
	
	public void replace(Column column){
		this.replacement.add(column);
	}
	
	public List<Column> getReplacement(){
		return this.replacement;
	}
	
	public void setColumn(IMetadataColumn column){
		this.column = column;
	}
	
	public IMetadataColumn getColumn(){
		return this.column;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}
	
	public void setDBName(String DBname){
		this.DBname = DBname;
	}

	public String getDBName(){
		return this.DBname;
	}
	
	public void setIsAddCol(boolean isadd){
		this.addCol = isadd;
	}
	
	public boolean isAddCol(){
		return this.addCol;
	}
	
	public void setSqlStmt(String sql){
		this.sqlStmt = sql;
	}
	
	public String getSqlStmt(){
		return this.sqlStmt;
	}
	
	public void setValue(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
}

StringBuffer insertColName = new StringBuffer();

StringBuffer insertValueStmt = new StringBuffer();

StringBuffer updateSetStmt = new StringBuffer();

StringBuffer updateWhereStmt = new StringBuffer();

List<Column> stmtStructure =  new LinkedList<Column>();

for(IMetadataColumn column:columnList){

	stmtStructure.add(new Column(column));

}

for(IMetadataColumn column:columnList){
	if(addCols != null && addCols.size()>0){
		for(Map<String, String> addCol:addCols){
			if(addCol.get("REFCOL").equals(column.getLabel())){
				int stmtIndex = 0;
				
				for(Column stmtStr:stmtStructure){					
					if(stmtStr.getName().equals(addCol.get("REFCOL"))){
						break;
					}
					stmtIndex++;
				}
				
				if(addCol.get("POS").equals("AFTER")){
					Column insertAfter = new Column("\"+"+addCol.get("NAME")+"+\"","\"+"+addCol.get("SQL")+"+\"",true);
					stmtStructure.add(stmtIndex+1,insertAfter);
				}else if(addCol.get("POS").equals("BEFORE")){
					Column insertBefore = new Column("\"+"+addCol.get("NAME")+"+\"","\"+"+addCol.get("SQL")+"+\"",true);
					stmtStructure.add(stmtIndex,insertBefore);
				}else if(addCol.get("POS").equals("REPLACE")){
					Column replacementCol = new Column("\"+"+addCol.get("NAME")+"+\"","\"+"+addCol.get("SQL")+"+\"",true);
					Column replacedCol = (Column) stmtStructure.get(stmtIndex);
					replacedCol.replace(replacementCol);
				}
			}
		}
	}
}

int counterOuter =0;
boolean firstKey = true;
boolean firstNoneKey = true;

for(Column colStmt:stmtStructure){
	String suffix = ",";
	
	if(colStmt.isReplaced()){		
		List<Column> replacedColumns = colStmt.getReplacement();
		int counterReplace = 0;
		if(counterOuter==(stmtStructure.size()-1) && counterReplace==(replacedColumns.size()-1) ){
			suffix = "";
		}
		for(Column replacement:replacedColumns){
			insertColName.append("\\\""+replacement.getName()+"\\\""+suffix);
			insertValueStmt.append(replacement.getSqlStmt()+suffix);
			if(!colStmt.getColumn().isKey()){
				if(!firstNoneKey){
					updateSetStmt.append(",");
				}else{
					firstNoneKey = false;
				}
				updateSetStmt.append("\\\""+replacement.getName()+"\\\"");
				updateSetStmt.append("=" + replacement.getSqlStmt());
			}else{
				if(!firstKey){
					updateWhereStmt.append(" AND ");
				}else{
					firstKey = false;
				}
				updateWhereStmt.append("\\\""+replacement.getName()+"\\\"");
				updateWhereStmt.append("=" + replacement.getSqlStmt());
			}
			counterReplace++;
		}
	}else{
		if(counterOuter==(stmtStructure.size()-1)){
			suffix = "";
		}
		if(colStmt.isAddCol()){
			insertColName.append("\\\""+colStmt.getDBName()+"\\\""+suffix);
			insertValueStmt.append(colStmt.getSqlStmt()+suffix);
			updateSetStmt.append("\\\""+colStmt.getDBName()+"\\\"");
			updateSetStmt.append("=" + colStmt.getSqlStmt()+suffix);
		}else{
			insertColName.append("\\\""+colStmt.getDBName()+"\\\""+suffix);
			insertValueStmt.append(colStmt.getValue()+suffix);
			if(!colStmt.getColumn().isKey()){
				if(!firstNoneKey){
					updateSetStmt.append(",");
				}else{
					firstNoneKey = false;
				}
				updateSetStmt.append("\\\""+colStmt.getDBName()+"\\\"");
				updateSetStmt.append(colStmt.getSqlStmt());
			}else{
				if(!firstKey){
					updateWhereStmt.append(" AND ");
				}else{
					firstKey = false;
				}
				updateWhereStmt.append("\\\""+colStmt.getDBName()+"\\\"");
				updateWhereStmt.append(colStmt.getSqlStmt());
			}
		}
	}
	counterOuter ++;
}


	if(dataAction.equals("INSERT")){
	
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_47);
    
	}else if (dataAction.equals("UPDATE")){
	
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_53);
    		
	}else if (dataAction.equals("INSERT_OR_UPDATE")){
	
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_68);
    
	}else if (dataAction.equals("UPDATE_OR_INSERT")){
	
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(updateSetStmt.toString());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(insertColName.toString());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(insertValueStmt.toString());
    stringBuffer.append(TEXT_79);
    
			
	}else if (dataAction.equals("DELETE")){
	
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(tableName);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(updateWhereStmt.toString());
    stringBuffer.append(TEXT_84);
    		
	}
}
if(!commitEvery.equals("")&&!commitEvery.equals("0")){

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(commitEvery);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
}

    stringBuffer.append(TEXT_90);
    stringBuffer.append(TEXT_91);
    return stringBuffer.toString();
  }
}
