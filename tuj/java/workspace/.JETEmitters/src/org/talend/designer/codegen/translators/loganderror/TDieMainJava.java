package org.talend.designer.codegen.translators.loganderror;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TDieMainJava
{
  protected static String nl;
  public static synchronized TDieMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TDieMainJava result = new TDieMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_4 = ".addMessage(\"tDie\", \"";
  protected final String TEXT_5 = "\", ";
  protected final String TEXT_6 = ", ";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_9 = "Process();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_10 = NL + NL + "\tSystem.err.println(";
  protected final String TEXT_11 = ");" + NL + "\tcurrentComponent = \"";
  protected final String TEXT_12 = "\";";
  protected final String TEXT_13 = NL + "        ((java.util.Map)threadLocal.get()).put(errorCode, new Integer(";
  protected final String TEXT_14 = ")); ";
  protected final String TEXT_15 = NL + "        errorCode = new Integer(";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\t" + NL + "\tif(true){" + NL + "\t    throw new TDieException();" + NL + "\t}";
  protected final String TEXT_18 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();

    stringBuffer.append(TEXT_2);
    
			if (node.getProcess().getNodesOfType("tLogCatcher").size() > 0) {
				List<INode> logCatchers = (List<INode>)node.getProcess().getNodesOfType("tLogCatcher");
				for (INode logCatcher : logCatchers) {
					if (ElementParameterParser.getValue(logCatcher, "__CATCH_TDIE__").equals("true")) {
						
    stringBuffer.append(TEXT_3);
    stringBuffer.append(logCatcher.getUniqueName() );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(ElementParameterParser.getValue(node, "__PRIORITY__") );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MESSAGE__") );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CODE__") );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(logCatcher.getUniqueName() );
    stringBuffer.append(TEXT_9);
    
					}
				}
			}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(ElementParameterParser.getValue(node, "__MESSAGE__") );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    
    if(isRunInMultiThread ){
    
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CODE__") );
    stringBuffer.append(TEXT_14);
    
        }else {
    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ElementParameterParser.getValue(node, "__CODE__") );
    stringBuffer.append(TEXT_16);
    
        }
    
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    return stringBuffer.toString();
  }
}
