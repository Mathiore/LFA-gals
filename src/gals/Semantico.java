package gals;

import gals.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants
{
    Stack<Integer> stack = new Stack();
    Map<String, Integer> vars = new HashMap<String, Integer>();
    String variavelAtual;
    public void executeAction(int action, Token token)	throws gals.SemanticError
    {
        Integer a, b;
        switch (action)
        { 
            case 1: //Empilha numeros
              stack.push(Integer.parseInt(token.getLexeme(), 2));
              break;
            case 2://adição
              b = stack.pop();
              a = stack.pop();
              stack.push(new Integer(a.intValue() + b.intValue()));
              break;
            case 3://multiplicação
              b = stack.pop();
              a = stack.pop();
              stack.push(new Integer(a.intValue() * b.intValue()));
              break;
            case 4: //Empilha variavel
              stack.push(vars.get(token.getLexeme()));
              break;
            case 5://subtração
              b = stack.pop();
              a = stack.pop();
              stack.push(new Integer(a.intValue() - b.intValue()));
              break;            
            case 6://divisão
              b = stack.pop();
              a = stack.pop();
              stack.push(new Integer(a.intValue() / b.intValue()));
              break;
            case 7: //exponeciação
              b = stack.pop();
              a = stack.pop();
              Double A = Math.pow(a, b);
              stack.push(A.intValue());
              break;
            case 8: //função show
              System.out.print("Resultado: "+Integer.toBinaryString(vars.get(variavelAtual))+"\n");
              break;            
            case 9: //salva variavel e valor
              vars.put(variavelAtual, stack.pop());
              break;
            case 10:    //variavel atual
              variavelAtual = token.getLexeme();
              break;
            case 11: // função log
              b = stack.pop();
              a = stack.pop();
              
              Double resultA = Math.log(a)/ Math.log(b);
             
              stack.push(new Integer(resultA.intValue()));
              break;
        }
    }	
}

