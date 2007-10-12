package org.talend.designer.codegen.translators.misc;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TForBeginJava
{
  protected static String nl;
  public static synchronized TForBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TForBeginJava result = new TForBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "globalMap.put(\"";
  protected final String TEXT_3 = "_CURRENT_ITERATION\",";
  protected final String TEXT_4 = ");";
  protected final String TEXT_5 = NL + "while (1) {";
  protected final String TEXT_6 = NL + "while ( ((Integer)globalMap.get(\"";
  protected final String TEXT_7 = "_CURRENT_ITERATION\")) <= ";
  protected final String TEXT_8 = ") {";
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String from = ElementParameterParser.getValue(node, "__FROM__");
String to   = ElementParameterParser.getValue(node, "__TO__");

if (from.equals("")) {
	from = "1";
}

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(from);
    stringBuffer.append(TEXT_4);
    
if (to.equals("")) {

    stringBuffer.append(TEXT_5);
    
} else {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(to);
    stringBuffer.append(TEXT_8);
    
}

    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
