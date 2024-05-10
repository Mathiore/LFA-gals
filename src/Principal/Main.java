package Principal;

import gals.*;
import java.io.IOException;
public class Main {
     public static void main(String[] args) throws IOException{
         
         try
         {
            
            Lexico lexico = new Lexico("A=11001^10;B=1101;C=A+B;show(C);D=log(A)|log(B);show(D);");
            
            Sintatico sintatico = new Sintatico();
            Semantico semantico = new Semantico();

            sintatico.parse(lexico, semantico);
        }
            catch ( LexicalError | SyntaticError | SemanticError e )
            {
                System.out.println("Comando não identificado.");
            }
  }
}
