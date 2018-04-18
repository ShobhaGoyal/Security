package Attacks;

import GetXsdConstraints.MNode;

public class DuplicateTag {
	
	public MNode duplicate(MNode mnode,MNode parent)
	{
		String elem = parent.getElem_name();
		String value = mnode.getTextvalue();		
		value = value + "</" + elem + ">" + "<"+elem + ">" + value;
		//System.out.println(value);
		mnode.setTextvalue(value);
		return mnode;
	}

}
