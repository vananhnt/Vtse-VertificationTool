package solver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import cfg.utils.Variable;

public class SMTInput {
	private ArrayList<Variable> variableList;
	private String formula;
	private ArrayList<String> constraints;
	public SMTInput(){
		
	}
	
	public SMTInput(ArrayList<Variable> varList, String formula){
		this.variableList = varList;
		this.formula = formula;		
	}
	
	public ArrayList<Variable> getVariableList() {
		return variableList;
	}
	public void setVariableList(ArrayList<Variable> variableList) {
		this.variableList = variableList;
	}
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}

	public ArrayList<String> getConstrain() {
		return constraints;
	}

	public void setConstrain(ArrayList<String> constrain) {
		this.constraints = constrain;
	}
	public void printInput() {
		System.err.println("print");
		for (Variable v: variableList) {
			String smtType = getSMTType(v.getType());
			if (v.hasInitialized()) {
				
				System.out.println("v: " + v);
				if ( v.getIndex() < 0)
					System.out.println("(declare-fun " + v.getVariableWithIndex() + " () " + smtType + ")");
				else {
					for (int i = 0; i <= v.getIndex(); i++)
						System.out.println(declare(v.getName(), i, smtType));
				}
			}
			else if (v.getName().equals("return")) {
				System.out.println("return return");
				System.out.println("(declare-fun return () " + smtType + ")");
			}
			
		}
//		for (String s: constraints) {
//			System.out.println("(assert " + s + ")");
//		}
			
		System.out.println("(assert " + formula + ")");	
	}
	
	public void printInputToOutputStream(OutputStream os) 
						throws IOException {
		Writer out = new BufferedWriter(new OutputStreamWriter(os));
		String smtType;
		for (Variable v: variableList) {
			smtType = getSMTType(v.getType());
			if (v.hasInitialized()) {
				
				System.out.println("v: " + v);
				if ( v.getIndex() < 0)
					out.append("(declare-fun " + v.getVariableWithIndex() + " () " + smtType + ")\n");
				else {
					for (int i = 0; i <= v.getIndex(); i++)
						out.append(declare(v.getName(), i, smtType) + "\n");
				}
			}
			else if (v.getName().equals("return")) {
				out.append("(declare-fun return () " + smtType + ")\n");
			}
		}
			
		out.append("(assert " + formula + ")\n");
	
		for (String s: constraints) {
			out.append("(assert " + s + ")\n");
		}
		
		out.append("(check-sat)\n");
		out.append("(get-model)");
		
		out.flush();
	    out.close();
	}
	
	private String getSMTType(String type) {
		String smtType = null;
		if (type.equalsIgnoreCase("bool"))
			smtType = "Bool";
		else if (type.equalsIgnoreCase("int") || type.equalsIgnoreCase("short"))
			smtType = "Int";
		else if (type.equalsIgnoreCase("float") || type.equalsIgnoreCase("double"))
			smtType = "Real";
		
		return smtType;
	}

	private String declare(String variableName, int index, String type) {
		String value = variableName + "_" + index;
		String declaration = "(declare-fun " + value + " () " + type + ")";
		return declaration;
	}

}