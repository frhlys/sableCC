package lexing;

import lexing.lexer.*; 
import lexing.node.*;
import java.io.*; // Needed for pushbackreader and inputstream

class Lexing
{
	static Lexer lexer;
	static Object token;

	public static void main(String [] args)
	{
		lexer = new Lexer (new PushbackReader (new InputStreamReader(System.in), 1024));
		token = null;
		
		try
		{
			while (! (token instanceof EOF))
			{
				token = lexer.next(); // read next token
			
				if (token instanceof TNum)
					System.out.print ("Integer Numeric Constant : ");
				else if (token instanceof TKeywords)
					System.out.print ("Keywords : ");
				else if (token instanceof TFloatNum)
					System.out.print ("Float Numeric Constant : ");
				else if (token instanceof TCharConst)
					System.out.print ("Char Numeric Constant : ");
				else if (token instanceof TStrConst)
					System.out.print ("String Constant : ");
				else if (token instanceof TIdent)
					System.out.print ("Identifier : ");
				else if (token instanceof TAssign)
					System.out.print ("Assignment : ");
				else if (token instanceof TArithOp)
					System.out.print ("Arithmetic Operater : ");
				else if (token instanceof TRelOp)
					System.out.print ("Relational Operater : ");
				else if (token instanceof TLogOp)
					System.out.print ("Logical Operator : ");
				else if (token instanceof TSpecChar)
					System.out.print ("Special Character : ");
				else if (token instanceof TParen)
					System.out.print ("Parentheses : ");
				else if (token instanceof TBlank);
					// Ignore white space
				else if (token instanceof TUnknown)
					System.out.print ("Unknown :  ");

				if (! (token instanceof TBlank))
					System.out.println (token);
			}
		}
		catch (LexerException le)
		{
			System.out.println("Lexer Exception "+le);
		}
		catch (IOException ioe)
		{
			System.out.println ("IO Exception " +ioe);
		}
	}
}