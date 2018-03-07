package Attacks;

import GetXsdConstraints.MNode;

public class RewriteTag {

	public MNode rewrite(MNode mnode,MNode parent)
	{
		String value = mnode.getTextvalue();
		value += "</"+parent.getElem_name()+"><!--";
		mnode.setTextvalue(value);
		return mnode;
	}
}
