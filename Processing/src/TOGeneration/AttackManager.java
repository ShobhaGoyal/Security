package TOGeneration;

import javax.xml.transform.TransformerException;

import Attacks.*;
import GetXsdConstraints.MNode;

public class AttackManager {
	
	public MNode addmetacharacter(MNode mnode) throws TransformerException
	{
		Metacharacter mc = new Metacharacter();
		mnode = mc.addmetacharacter(mnode);
		
		System.out.println("addmetacharacter attack on "+mnode.getTextvalue());
		return mnode;
	}
	
	public MNode addrandomclosingtag(MNode mnode,MNode parent)
	{
		ClosingTag ct = new ClosingTag();
		mnode = ct.addrandomclosingtag(mnode,parent);
		System.out.println("addrandomclosingtag attack on "+mnode.getTextvalue());
		return mnode;
	}
	
	public void duplicatetag(MNode mnode)   // create previous tag again so that its value will overwrite previous one
	{
		System.out.println("duplicatetag attack on "+mnode.getTextvalue());
	}
	
	public void rewritetag(MNode mnode)   // replace previous tag and create same tag with malicious value
	{
		System.out.println("rewritetag attack on "+mnode.getTextvalue());
	}

}
