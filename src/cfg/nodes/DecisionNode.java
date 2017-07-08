package cfg.nodes;

import org.eclipse.cdt.core.dom.ast.IASTExpression;
import org.eclipse.cdt.core.dom.ast.IASTStatement;
import org.eclipse.cdt.internal.core.dom.parser.cpp.CPPASTExpressionStatement;
import org.eclipse.cdt.internal.core.util.ToStringSorter;

public class DecisionNode extends CFGNode{
	private IASTExpression condition;
	private CFGNode thenNode;
	private EndingNode endNode;
	// elseNode is next
	
	public DecisionNode(){
		super();		
	}
	
	public DecisionNode( CFGNode prev, EndingNode next){
		this.setPrev(prev);
		this.endNode = next;
	}	
	
	public IASTExpression getCondition() {
		return condition;
	}
	public void setCondition(IASTExpression iastExpression) {
		this.condition = iastExpression;
	}
	
//	set THEN NODE with Input is CFGNode  or  IASTStatement		
	public CFGNode getThenNode() {
		return thenNode;
	}	
	public void setThenNode(CFGNode thenNode) {
		this.thenNode = thenNode;
	}
	
	
// set ELSE NODE with Input is CFGNode  or  IASTStatement	
	public void setElseNode( CFGNode elseNode){
		this.setNext(elseNode);
	}
	
	public CFGNode getElseNode(){
		return this.getNext();
	}
	
	
	public EndingNode getEndNode() {
		return endNode;
	}
	
	public void setEndNode( CFGNode endNode){
		this.endNode = new EndingNode( endNode);
	}
	public String toString(){
		
		 // TODO
		return null;
	}
		
}
