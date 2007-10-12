package org.talend.designer.codegen.translators.databases.mysql;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TMysqlSPBeginJava
{
  protected static String nl;
  public static synchronized TMysqlSPBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMysqlSPBeginJava result = new TMysqlSPBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "java.lang.Class.forName(\"org.gjt.mm.mysql.Driver\");" + NL + "String connectionString_";
  protected final String TEXT_3 = " = \"jdbc:mysql://\" + ";
  protected final String TEXT_4 = " + \":\" + ";
  protected final String TEXT_5 = " + \"/\" + ";
  protected final String TEXT_6 = " + \"?noDatetimeStringSync=true\";" + NL + "java.sql.Connection connection_";
  protected final String TEXT_7 = " = java.sql.DriverManager.getConnection(connectionString_";
  protected final String TEXT_8 = ", ";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ");" + NL + "" + NL + "java.sql.CallableStatement statement_";
  protected final String TEXT_11 = " = connection_";
  protected final String TEXT_12 = ".prepareCall(\"{";
  protected final String TEXT_13 = "call ";
  protected final String TEXT_14 = "(";
  protected final String TEXT_15 = "?,";
  protected final String TEXT_16 = "?";
  protected final String TEXT_17 = ")}\");" + NL + "" + NL + "java.sql.Date tmpDate_";
  protected final String TEXT_18 = ";" + NL + "String tmpString_";
  protected final String TEXT_19 = ";";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

String dbhost = ElementParameterParser.getValue(node, "__HOST__");
String dbport = ElementParameterParser.getValue(node, "__PORT__");
String dbname = ElementParameterParser.getValue(node, "__DBNAME__");
String dbuser = ElementParameterParser.getValue(node, "__USER__");
String dbpwd  = ElementParameterParser.getValue(node, "__PASS__");
String spName = ElementParameterParser.getValue(node, "__SP_NAME__");
boolean isFunction = ElementParameterParser.getValue(node, "__IS_FUNCTION__").equals("true");
List<Map<String, String>> spArgs = (List<Map<String,String>>) ElementParameterParser.getObjectValue(node, "__SP_ARGS__");


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(dbhost);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(dbport);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(dbname);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(dbuser);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(dbpwd);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(isFunction ? "? = " : "");
    stringBuffer.append(TEXT_13);
    stringBuffer.append(spName);
    stringBuffer.append(TEXT_14);
    
for (int i = 0; i < spArgs.size(); i++) {
	if (i < spArgs.size() - 1) {
		
    stringBuffer.append(TEXT_15);
    
	} else {
		
    stringBuffer.append(TEXT_16);
    
	}
}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
