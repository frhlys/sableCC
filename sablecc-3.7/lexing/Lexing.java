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
	lexer = new Lexer (new PushbackReader(new InputStreamReader (System.in), 1024));
	token = null;
	try
	{
		while ( ! (token instanceof EOF))
		{ 	token = lexer.next(); // read next token
                        //num
			if (token instanceof TNum)
				System.out.print ("Number: ");
                        //key words
                        else if (token instanceof TKeywords) 
				System.out.print ("Key Word: ");
                        //float
                        else if (token instanceof TFloatNum) 
				System.out.print ("Float Num: ");
                        //char
                        else if (token instanceof TCharConst) 
				System.out.print ("Char Constant: ");
                        //String
                        else if (token instanceof TStrConst) 
				System.out.print ("String Constant: ");
                        //ident
                        else if (token instanceof TIdent) 
				System.out.print ("Identifier: ");
                        //Assign
                        else if (token instanceof TAssign) 
				System.out.print ("Assign: ");
                        //Arithmetic Operation
			else if (token instanceof TArithOp)
				System.out.print ("Arith Op: ");
                        //Relational Opertaion
			else if (token instanceof TRelOp)
				System.out.print ("Relational Op: ");
                        //Logical Operation
                        else if (token instanceof TLogOp)
				System.out.print ("Logical Op: ");
                        //Special Char
                        else if (token instanceof TSpecChar) 
				System.out.print ("Special Char: ");
                        //Parentheses
			else if (token instanceof TParen)
				System.out.print ("Parentheses: ");
                        //blank
			else if (token instanceof TBlank) ;
				// Ignore white space
                        //unknown
			else if (token instanceof TUnknown)
				System.out.print ("Unknown: ");
			if (! (token instanceof TBlank))
				System.out.println (token); 
		}
	}
	catch (LexerException le)
	{ System.out.println ("Lexer Exception " + le); }
	catch (IOException ioe)
	{ System.out.println ("IO Exception " +ioe); }
	}
}
