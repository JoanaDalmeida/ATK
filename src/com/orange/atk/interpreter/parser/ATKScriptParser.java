/*
 * Software Name : ATK
 *
 * Copyright (C) 2007 - 2012 France Télécom
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * ------------------------------------------------------------------
 * File Name   : ATKScriptParser.java
 *
 * Created     : 21/05/2010
 * Author(s)   : HENAFF Mari-Mai
 */
package com.orange.atk.interpreter.parser;
import com.orange.atk.interpreter.ast.ASTCOMMENT;
import com.orange.atk.interpreter.ast.ASTFUNCTION;
import com.orange.atk.interpreter.ast.ASTINCLUDE;
import com.orange.atk.interpreter.ast.ASTLOOP;
import com.orange.atk.interpreter.ast.ASTNUMBER;
import com.orange.atk.interpreter.ast.ASTSETVAR;
import com.orange.atk.interpreter.ast.ASTSTRING;
import com.orange.atk.interpreter.ast.ASTStart;
import com.orange.atk.interpreter.ast.ASTTABLE;
import com.orange.atk.interpreter.ast.ASTVARIABLE;
import com.orange.atk.interpreter.ast.JJTATKScriptParserState;

public class ATKScriptParser/*@bgen(jjtree)*/implements ATKScriptParserTreeConstants, ATKScriptParserConstants {/*@bgen(jjtree)*/
  protected JJTATKScriptParserState jjtree = new JJTATKScriptParserState();public static void main(String args[]) throws ParseException
    {
        try{

                        ATKScriptParser parser = new ATKScriptParser(new java.io.FileReader(args[0]));
                        ASTStart expr = parser.start();
                        expr.dump("");
                        }catch(Exception e){
                        e.printStackTrace();
                }
    }

/*****************************************
***** SECTION 4 - THE GRAMMAR        *****
*****************************************/
  final public ASTStart start() throws ParseException {
                           /*@bgen(jjtree) Start */
  ASTStart jjtn000 = new ASTStart(JJTSTART);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      parseFile();
                       jjtree.closeNodeScope(jjtn000, true);
                       jjtc000 = false;
                       {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
    throw new Error("Missing return statement in function");
  }

  final public void parseFile() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 0:
      case LOOP:
      case INCLUDE:
      case SETVAR:
      case EOL:
      case STRING:
      case SINGLE_LINE_COMMENT:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LOOP:
      case INCLUDE:
      case SETVAR:
      case STRING:
        statement();
        break;
      default:
        jj_la1[1] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SINGLE_LINE_COMMENT:
        comment();
        break;
      default:
        jj_la1[2] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 0:
        jj_consume_token(0);
                                                    {if (true) return;}
        break;
      case EOL:
        jj_consume_token(EOL);
        break;
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING:
      function();
      break;
    case LOOP:
      loop();
      break;
    case SETVAR:
      setvar();
      break;
    case INCLUDE:
      include();
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void comment() throws ParseException {
                           /*@bgen(jjtree) COMMENT */
                           ASTCOMMENT jjtn000 = new ASTCOMMENT(JJTCOMMENT);
                           boolean jjtc000 = true;
                           jjtree.openNodeScope(jjtn000);Token value;
    try {
      value = jj_consume_token(SINGLE_LINE_COMMENT);
     jjtree.closeNodeScope(jjtn000, true);
     jjtc000 = false;
   jjtn000.setValue(value.image);
    } finally {
     if (jjtc000) {
       jjtree.closeNodeScope(jjtn000, true);
     }
    }
  }

  final public void function() throws ParseException {
                            /*@bgen(jjtree) FUNCTION */
                            ASTFUNCTION jjtn000 = new ASTFUNCTION(JJTFUNCTION);
                            boolean jjtc000 = true;
                            jjtree.openNodeScope(jjtn000);Token value;
    try {
      value = jj_consume_token(STRING);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 14:
        jj_consume_token(14);
        listeArgs();
        jj_consume_token(15);
        break;
      default:
        jj_la1[5] = jj_gen;
        ;
      }
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
                jjtn000.setValue(value.image);
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  final public void include() throws ParseException {
                           /*@bgen(jjtree) Include */
                           ASTINCLUDE jjtn000 = new ASTINCLUDE(JJTINCLUDE);
                           boolean jjtc000 = true;
                           jjtree.openNodeScope(jjtn000);Token value;
    try {
      value = jj_consume_token(INCLUDE);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 14:
        jj_consume_token(14);
        string();
        jj_consume_token(15);
        break;
      default:
        jj_la1[6] = jj_gen;
        ;
      }
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
        jjtn000.setValue( value.image );
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  final public void listeArgs() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
    case VARNAME:
    case STRING:
    case 17:
      litteral();
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 16:
          ;
          break;
        default:
          jj_la1[7] = jj_gen;
          break label_2;
        }
        jj_consume_token(16);
        litteral();
      }
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
  }

  final public void setvar() throws ParseException {
                         /*@bgen(jjtree) SETVAR */
  ASTSETVAR jjtn000 = new ASTSETVAR(JJTSETVAR);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(SETVAR);
      jj_consume_token(14);
      string();
      jj_consume_token(16);
      value();
      jj_consume_token(15);
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  final public void loop() throws ParseException {
                     /*@bgen(jjtree) LOOP */
  ASTLOOP jjtn000 = new ASTLOOP(JJTLOOP);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(LOOP);
      jj_consume_token(14);
      litteral();
      jj_consume_token(15);
      parseFile();
      jj_consume_token(ENDL);
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  final public void litteral() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 17:
      table();
      break;
    case NUMBER:
    case STRING:
      value();
      break;
    case VARNAME:
      variable();
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void value() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case STRING:
      string();
      break;
    case NUMBER:
      number();
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void table() throws ParseException {
                     /*@bgen(jjtree) TABLE */
  ASTTABLE jjtn000 = new ASTTABLE(JJTTABLE);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(17);
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case NUMBER:
        case STRING:
          ;
          break;
        default:
          jj_la1[11] = jj_gen;
          break label_3;
        }
        value();
      }
      jj_consume_token(18);
    } catch (Throwable jjte000) {
    if (jjtc000) {
      jjtree.clearNodeScope(jjtn000);
      jjtc000 = false;
    } else {
      jjtree.popNode();
    }
    if (jjte000 instanceof RuntimeException) {
      {if (true) throw (RuntimeException)jjte000;}
    }
    if (jjte000 instanceof ParseException) {
      {if (true) throw (ParseException)jjte000;}
    }
    {if (true) throw (Error)jjte000;}
    } finally {
    if (jjtc000) {
      jjtree.closeNodeScope(jjtn000, true);
    }
    }
  }

  final public void string() throws ParseException {
                        /*@bgen(jjtree) STRING */
                        ASTSTRING jjtn000 = new ASTSTRING(JJTSTRING);
                        boolean jjtc000 = true;
                        jjtree.openNodeScope(jjtn000);Token value;
    try {
      value = jj_consume_token(STRING);
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
                jjtn000.setValue( value.image );
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  final public void number() throws ParseException {
                         /*@bgen(jjtree) NUMBER */
                         ASTNUMBER jjtn000 = new ASTNUMBER(JJTNUMBER);
                         boolean jjtc000 = true;
                         jjtree.openNodeScope(jjtn000);Token value;
    try {
      value = jj_consume_token(NUMBER);
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
                jjtn000.setValue( value.image );
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  final public void variable() throws ParseException {
                             /*@bgen(jjtree) VARIABLE */
                             ASTVARIABLE jjtn000 = new ASTVARIABLE(JJTVARIABLE);
                             boolean jjtc000 = true;
                             jjtree.openNodeScope(jjtn000);Token value;
    try {
      value = jj_consume_token(VARNAME);
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
                jjtn000.setValue( value.image );
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  /** Generated Token Manager. */
  public ATKScriptParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[12];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x2a69,0x868,0x2000,0x201,0x868,0x4000,0x4000,0x10000,0x20c80,0x20c80,0x880,0x880,};
   }

  /** Constructor with InputStream. */
  public ATKScriptParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ATKScriptParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ATKScriptParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ATKScriptParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ATKScriptParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ATKScriptParser(ATKScriptParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ATKScriptParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[19];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 12; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 19; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}