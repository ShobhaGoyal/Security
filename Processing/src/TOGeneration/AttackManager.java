package TOGeneration;

import javax.xml.transform.TransformerException;

import Attacks.*;
import GetXsdConstraints.MNode;

public class AttackManager {
	
	public MNode addmetacharacter(MNode mnode,MNode parent) throws TransformerException
	{
		Metacharacter mc = new Metacharacter();
		mnode = mc.addmetacharacter(mnode);
		
		System.out.println("addmetacharacter attack on "+parent.getElem_name());
		return mnode;
	}
	
	public MNode addrandomclosingtag(MNode mnode,MNode parent)
	{
		ClosingTag ct = new ClosingTag();
		mnode = ct.addrandomclosingtag(mnode,parent);
		System.out.println("addrandomclosingtag attack on "+parent.getElem_name());
		return mnode;
	}
	
	public MNode duplicatetag(MNode mnode,MNode parent)   // create previous tag again so that its value will overwrite previous one
	{
		DuplicateTag dt = new DuplicateTag();
		mnode = dt.duplicate(mnode,parent);
		System.out.println("duplicatetag attack on "+parent.getElem_name());
		return mnode;
	}
	
	public MNode rewritetag(MNode mnode,MNode parent)   // replace previous tag and create same tag with malicious value
	{
		RewriteTag rt = new RewriteTag();
		mnode = rt.rewrite(mnode,parent);
		System.out.println("rewritetag attack on "+parent.getElem_name());
		return mnode;
	}

}
