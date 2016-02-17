import java.io.*;

class Cutter {
	FileInputStream fileStream;
	int character;
	int tag;
	BinaryTree heap;
	Cutter() {
	}

	Cutter(String filePath) {
		try {
			tag = 0;
			character = 0;
			fileStream = new FileInputStream(filePath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void split()
	{
		String word=new String();
		heap=new BinaryTree();
		try{
			do
			{
				character=fileStream.read();
				if((char)character=='<')
				{
					tag=1;
					continue;
				}else if((char)character=='>')
				{
					tag=0;
					continue;
				}else if((char)character=='-')
				{
					continue;
				}
				
				if((char)character==' ' || (char)character==';' || (char)character==',' || (char)character=='.' || (char)character=='\n' 
						|| (char)character=='\r' || (char)character=='\''
						  ||(char)character=='!'||(char)character=='_'||(char)character=='?'||(char)character=='"'
						  ||(char)character=='('||(char)character==')'||(char)character==':')
				{
					
					if(word.equals("a") || word.equals("the") || word.equals("of") || word.equals("be") || word.equals("")
							   ||word.equals("s")||word.equals("at") ||word.equals("on")||word.equals("in")
							   ||word.equals("which")||word.equals("that")||word.equals("what")||word.equals("as"))
					   {
						   	  word="";
						      continue;
					   }else //단어 만들기
					   {
						   //System.out.println(word);
						   heap.insert(word);
						   	   word="";
						   	   continue;
					   }
				}
				if(tag==0)
				{
					word+=(char)character;
					word=word.toLowerCase();
				}
			}while(character!=-1);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}

public class reader {

	public static void main(String[] args) {
		Cutter test=new Cutter("./book_1.xml");
		test.split();
		test.heap.traverse();
	}
}