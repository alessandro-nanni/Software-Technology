package org.xtext.example.computer.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.computer.services.ComputerDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalComputerDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'{'", "'}'", "'import'", "'.'", "'.*'", "'computer'", "'motherboard'", "'processor'", "'graphics'", "'memory'", "','", "'storage'", "'drive'", "'peripherals'", "'psu'", "'power'", "'type'", "'chipset'", "'socket'", "'ports'", "'model'", "'cores'", "'vram'", "'capacity'", "'port'", "'rating'", "'monitor'", "'keyboard'", "'mouse'", "'printer'", "'ATX'", "'MicroATX'", "'MiniITX'", "'AM4'", "'AM5'", "'LGA1200'", "'LGA1700'", "'USB'", "'PS2'", "'HDMI'", "'DisplayPort'", "'VGA'", "'Ethernet'", "'Audio'", "'DDR4'", "'DDR5'", "'HDD'", "'SSD'", "'CD_ROM'", "'CD_R'", "'CD_RW'", "'DVD_ROM'", "'BluRay'", "'Bronze'", "'Silver'", "'Gold'", "'Platinum'", "'Titanium'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalComputerDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalComputerDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalComputerDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalComputerDsl.g"; }



     	private ComputerDslGrammarAccess grammarAccess;

        public InternalComputerDslParser(TokenStream input, ComputerDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected ComputerDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalComputerDsl.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalComputerDsl.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalComputerDsl.g:66:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalComputerDsl.g:72:1: ruleModel returns [EObject current=null] : ( (lv_elements_0_0= ruleAbstractElement ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;



        	enterRule();

        try {
            // InternalComputerDsl.g:78:2: ( ( (lv_elements_0_0= ruleAbstractElement ) )* )
            // InternalComputerDsl.g:79:2: ( (lv_elements_0_0= ruleAbstractElement ) )*
            {
            // InternalComputerDsl.g:79:2: ( (lv_elements_0_0= ruleAbstractElement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==14||(LA1_0>=17 && LA1_0<=21)||(LA1_0>=23 && LA1_0<=24)||LA1_0==26||(LA1_0>=38 && LA1_0<=41)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalComputerDsl.g:80:3: (lv_elements_0_0= ruleAbstractElement )
            	    {
            	    // InternalComputerDsl.g:80:3: (lv_elements_0_0= ruleAbstractElement )
            	    // InternalComputerDsl.g:81:4: lv_elements_0_0= ruleAbstractElement
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getElementsAbstractElementParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_elements_0_0=ruleAbstractElement();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"elements",
            	    					lv_elements_0_0,
            	    					"org.xtext.example.computer.ComputerDsl.AbstractElement");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleAbstractElement"
    // InternalComputerDsl.g:101:1: entryRuleAbstractElement returns [EObject current=null] : iv_ruleAbstractElement= ruleAbstractElement EOF ;
    public final EObject entryRuleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractElement = null;


        try {
            // InternalComputerDsl.g:101:56: (iv_ruleAbstractElement= ruleAbstractElement EOF )
            // InternalComputerDsl.g:102:2: iv_ruleAbstractElement= ruleAbstractElement EOF
            {
             newCompositeNode(grammarAccess.getAbstractElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAbstractElement=ruleAbstractElement();

            state._fsp--;

             current =iv_ruleAbstractElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // InternalComputerDsl.g:108:1: ruleAbstractElement returns [EObject current=null] : (this_PackageDeclaration_0= rulePackageDeclaration | this_Import_1= ruleImport | this_Part_2= rulePart | this_Computer_3= ruleComputer ) ;
    public final EObject ruleAbstractElement() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDeclaration_0 = null;

        EObject this_Import_1 = null;

        EObject this_Part_2 = null;

        EObject this_Computer_3 = null;



        	enterRule();

        try {
            // InternalComputerDsl.g:114:2: ( (this_PackageDeclaration_0= rulePackageDeclaration | this_Import_1= ruleImport | this_Part_2= rulePart | this_Computer_3= ruleComputer ) )
            // InternalComputerDsl.g:115:2: (this_PackageDeclaration_0= rulePackageDeclaration | this_Import_1= ruleImport | this_Part_2= rulePart | this_Computer_3= ruleComputer )
            {
            // InternalComputerDsl.g:115:2: (this_PackageDeclaration_0= rulePackageDeclaration | this_Import_1= ruleImport | this_Part_2= rulePart | this_Computer_3= ruleComputer )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 14:
                {
                alt2=2;
                }
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 24:
            case 26:
            case 38:
            case 39:
            case 40:
            case 41:
                {
                alt2=3;
                }
                break;
            case 17:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalComputerDsl.g:116:3: this_PackageDeclaration_0= rulePackageDeclaration
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getPackageDeclarationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PackageDeclaration_0=rulePackageDeclaration();

                    state._fsp--;


                    			current = this_PackageDeclaration_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:125:3: this_Import_1= ruleImport
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Import_1=ruleImport();

                    state._fsp--;


                    			current = this_Import_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalComputerDsl.g:134:3: this_Part_2= rulePart
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getPartParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Part_2=rulePart();

                    state._fsp--;


                    			current = this_Part_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalComputerDsl.g:143:3: this_Computer_3= ruleComputer
                    {

                    			newCompositeNode(grammarAccess.getAbstractElementAccess().getComputerParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Computer_3=ruleComputer();

                    state._fsp--;


                    			current = this_Computer_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRulePackageDeclaration"
    // InternalComputerDsl.g:155:1: entryRulePackageDeclaration returns [EObject current=null] : iv_rulePackageDeclaration= rulePackageDeclaration EOF ;
    public final EObject entryRulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDeclaration = null;


        try {
            // InternalComputerDsl.g:155:59: (iv_rulePackageDeclaration= rulePackageDeclaration EOF )
            // InternalComputerDsl.g:156:2: iv_rulePackageDeclaration= rulePackageDeclaration EOF
            {
             newCompositeNode(grammarAccess.getPackageDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackageDeclaration=rulePackageDeclaration();

            state._fsp--;

             current =iv_rulePackageDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // InternalComputerDsl.g:162:1: rulePackageDeclaration returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' ) ;
    public final EObject rulePackageDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_elements_3_0 = null;



        	enterRule();

        try {
            // InternalComputerDsl.g:168:2: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' ) )
            // InternalComputerDsl.g:169:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' )
            {
            // InternalComputerDsl.g:169:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}' )
            // InternalComputerDsl.g:170:3: otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' ( (lv_elements_3_0= ruleAbstractElement ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0());
            		
            // InternalComputerDsl.g:174:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalComputerDsl.g:175:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalComputerDsl.g:175:4: (lv_name_1_0= ruleQualifiedName )
            // InternalComputerDsl.g:176:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.example.computer.ComputerDsl.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getPackageDeclarationAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalComputerDsl.g:197:3: ( (lv_elements_3_0= ruleAbstractElement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11||LA3_0==14||(LA3_0>=17 && LA3_0<=21)||(LA3_0>=23 && LA3_0<=24)||LA3_0==26||(LA3_0>=38 && LA3_0<=41)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalComputerDsl.g:198:4: (lv_elements_3_0= ruleAbstractElement )
            	    {
            	    // InternalComputerDsl.g:198:4: (lv_elements_3_0= ruleAbstractElement )
            	    // InternalComputerDsl.g:199:5: lv_elements_3_0= ruleAbstractElement
            	    {

            	    					newCompositeNode(grammarAccess.getPackageDeclarationAccess().getElementsAbstractElementParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_6);
            	    lv_elements_3_0=ruleAbstractElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getPackageDeclarationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elements",
            	    						lv_elements_3_0,
            	    						"org.xtext.example.computer.ComputerDsl.AbstractElement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getPackageDeclarationAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRuleImport"
    // InternalComputerDsl.g:224:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalComputerDsl.g:224:47: (iv_ruleImport= ruleImport EOF )
            // InternalComputerDsl.g:225:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalComputerDsl.g:231:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;



        	enterRule();

        try {
            // InternalComputerDsl.g:237:2: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) )
            // InternalComputerDsl.g:238:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            {
            // InternalComputerDsl.g:238:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            // InternalComputerDsl.g:239:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalComputerDsl.g:243:3: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            // InternalComputerDsl.g:244:4: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            {
            // InternalComputerDsl.g:244:4: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            // InternalComputerDsl.g:245:5: lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard
            {

            					newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildcard();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getImportRule());
            					}
            					set(
            						current,
            						"importedNamespace",
            						lv_importedNamespace_1_0,
            						"org.xtext.example.computer.ComputerDsl.QualifiedNameWithWildcard");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalComputerDsl.g:266:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalComputerDsl.g:266:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalComputerDsl.g:267:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalComputerDsl.g:273:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalComputerDsl.g:279:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalComputerDsl.g:280:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalComputerDsl.g:280:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalComputerDsl.g:281:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalComputerDsl.g:288:3: (kw= '.' this_ID_2= RULE_ID )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalComputerDsl.g:289:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,15,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_7); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // InternalComputerDsl.g:306:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // InternalComputerDsl.g:306:65: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // InternalComputerDsl.g:307:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // InternalComputerDsl.g:313:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;



        	enterRule();

        try {
            // InternalComputerDsl.g:319:2: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // InternalComputerDsl.g:320:2: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // InternalComputerDsl.g:320:2: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // InternalComputerDsl.g:321:3: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {

            			newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0());
            		
            pushFollow(FOLLOW_8);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            			current.merge(this_QualifiedName_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalComputerDsl.g:331:3: (kw= '.*' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalComputerDsl.g:332:4: kw= '.*'
                    {
                    kw=(Token)match(input,16,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleComputer"
    // InternalComputerDsl.g:342:1: entryRuleComputer returns [EObject current=null] : iv_ruleComputer= ruleComputer EOF ;
    public final EObject entryRuleComputer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputer = null;


        try {
            // InternalComputerDsl.g:342:49: (iv_ruleComputer= ruleComputer EOF )
            // InternalComputerDsl.g:343:2: iv_ruleComputer= ruleComputer EOF
            {
             newCompositeNode(grammarAccess.getComputerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComputer=ruleComputer();

            state._fsp--;

             current =iv_ruleComputer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComputer"


    // $ANTLR start "ruleComputer"
    // InternalComputerDsl.g:349:1: ruleComputer returns [EObject current=null] : (otherlv_0= 'computer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'motherboard' ( ( ruleQualifiedName ) ) otherlv_5= 'processor' ( ( ruleQualifiedName ) ) (otherlv_7= 'graphics' ( ( ruleQualifiedName ) ) )? otherlv_9= 'memory' ( ( ruleQualifiedName ) ) (otherlv_11= ',' ( ( ruleQualifiedName ) ) )* otherlv_13= 'storage' ( ( ruleQualifiedName ) ) (otherlv_15= ',' ( ( ruleQualifiedName ) ) )* (otherlv_17= 'drive' ( ( ruleQualifiedName ) ) )? (otherlv_19= 'peripherals' ( ( ruleQualifiedName ) ) (otherlv_21= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_23= 'psu' ( ( ruleQualifiedName ) ) otherlv_25= '}' ) ;
    public final EObject ruleComputer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;


        	enterRule();

        try {
            // InternalComputerDsl.g:355:2: ( (otherlv_0= 'computer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'motherboard' ( ( ruleQualifiedName ) ) otherlv_5= 'processor' ( ( ruleQualifiedName ) ) (otherlv_7= 'graphics' ( ( ruleQualifiedName ) ) )? otherlv_9= 'memory' ( ( ruleQualifiedName ) ) (otherlv_11= ',' ( ( ruleQualifiedName ) ) )* otherlv_13= 'storage' ( ( ruleQualifiedName ) ) (otherlv_15= ',' ( ( ruleQualifiedName ) ) )* (otherlv_17= 'drive' ( ( ruleQualifiedName ) ) )? (otherlv_19= 'peripherals' ( ( ruleQualifiedName ) ) (otherlv_21= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_23= 'psu' ( ( ruleQualifiedName ) ) otherlv_25= '}' ) )
            // InternalComputerDsl.g:356:2: (otherlv_0= 'computer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'motherboard' ( ( ruleQualifiedName ) ) otherlv_5= 'processor' ( ( ruleQualifiedName ) ) (otherlv_7= 'graphics' ( ( ruleQualifiedName ) ) )? otherlv_9= 'memory' ( ( ruleQualifiedName ) ) (otherlv_11= ',' ( ( ruleQualifiedName ) ) )* otherlv_13= 'storage' ( ( ruleQualifiedName ) ) (otherlv_15= ',' ( ( ruleQualifiedName ) ) )* (otherlv_17= 'drive' ( ( ruleQualifiedName ) ) )? (otherlv_19= 'peripherals' ( ( ruleQualifiedName ) ) (otherlv_21= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_23= 'psu' ( ( ruleQualifiedName ) ) otherlv_25= '}' )
            {
            // InternalComputerDsl.g:356:2: (otherlv_0= 'computer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'motherboard' ( ( ruleQualifiedName ) ) otherlv_5= 'processor' ( ( ruleQualifiedName ) ) (otherlv_7= 'graphics' ( ( ruleQualifiedName ) ) )? otherlv_9= 'memory' ( ( ruleQualifiedName ) ) (otherlv_11= ',' ( ( ruleQualifiedName ) ) )* otherlv_13= 'storage' ( ( ruleQualifiedName ) ) (otherlv_15= ',' ( ( ruleQualifiedName ) ) )* (otherlv_17= 'drive' ( ( ruleQualifiedName ) ) )? (otherlv_19= 'peripherals' ( ( ruleQualifiedName ) ) (otherlv_21= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_23= 'psu' ( ( ruleQualifiedName ) ) otherlv_25= '}' )
            // InternalComputerDsl.g:357:3: otherlv_0= 'computer' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'motherboard' ( ( ruleQualifiedName ) ) otherlv_5= 'processor' ( ( ruleQualifiedName ) ) (otherlv_7= 'graphics' ( ( ruleQualifiedName ) ) )? otherlv_9= 'memory' ( ( ruleQualifiedName ) ) (otherlv_11= ',' ( ( ruleQualifiedName ) ) )* otherlv_13= 'storage' ( ( ruleQualifiedName ) ) (otherlv_15= ',' ( ( ruleQualifiedName ) ) )* (otherlv_17= 'drive' ( ( ruleQualifiedName ) ) )? (otherlv_19= 'peripherals' ( ( ruleQualifiedName ) ) (otherlv_21= ',' ( ( ruleQualifiedName ) ) )* )? otherlv_23= 'psu' ( ( ruleQualifiedName ) ) otherlv_25= '}'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getComputerAccess().getComputerKeyword_0());
            		
            // InternalComputerDsl.g:361:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalComputerDsl.g:362:4: (lv_name_1_0= RULE_ID )
            {
            // InternalComputerDsl.g:362:4: (lv_name_1_0= RULE_ID )
            // InternalComputerDsl.g:363:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getComputerAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComputerRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getComputerAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,18,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getComputerAccess().getMotherboardKeyword_3());
            		
            // InternalComputerDsl.g:387:3: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:388:4: ( ruleQualifiedName )
            {
            // InternalComputerDsl.g:388:4: ( ruleQualifiedName )
            // InternalComputerDsl.g:389:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComputerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getComputerAccess().getMotherboardMotherboardCrossReference_4_0());
            				
            pushFollow(FOLLOW_10);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,19,FOLLOW_4); 

            			newLeafNode(otherlv_5, grammarAccess.getComputerAccess().getProcessorKeyword_5());
            		
            // InternalComputerDsl.g:407:3: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:408:4: ( ruleQualifiedName )
            {
            // InternalComputerDsl.g:408:4: ( ruleQualifiedName )
            // InternalComputerDsl.g:409:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComputerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getComputerAccess().getProcessorProcessorCrossReference_6_0());
            				
            pushFollow(FOLLOW_11);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalComputerDsl.g:423:3: (otherlv_7= 'graphics' ( ( ruleQualifiedName ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalComputerDsl.g:424:4: otherlv_7= 'graphics' ( ( ruleQualifiedName ) )
                    {
                    otherlv_7=(Token)match(input,20,FOLLOW_4); 

                    				newLeafNode(otherlv_7, grammarAccess.getComputerAccess().getGraphicsKeyword_7_0());
                    			
                    // InternalComputerDsl.g:428:4: ( ( ruleQualifiedName ) )
                    // InternalComputerDsl.g:429:5: ( ruleQualifiedName )
                    {
                    // InternalComputerDsl.g:429:5: ( ruleQualifiedName )
                    // InternalComputerDsl.g:430:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComputerRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getComputerAccess().getGraphicsCardGraphicsCardCrossReference_7_1_0());
                    					
                    pushFollow(FOLLOW_12);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,21,FOLLOW_4); 

            			newLeafNode(otherlv_9, grammarAccess.getComputerAccess().getMemoryKeyword_8());
            		
            // InternalComputerDsl.g:449:3: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:450:4: ( ruleQualifiedName )
            {
            // InternalComputerDsl.g:450:4: ( ruleQualifiedName )
            // InternalComputerDsl.g:451:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComputerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getComputerAccess().getMemoryMemoryCrossReference_9_0());
            				
            pushFollow(FOLLOW_13);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalComputerDsl.g:465:3: (otherlv_11= ',' ( ( ruleQualifiedName ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==22) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalComputerDsl.g:466:4: otherlv_11= ',' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_11=(Token)match(input,22,FOLLOW_4); 

            	    				newLeafNode(otherlv_11, grammarAccess.getComputerAccess().getCommaKeyword_10_0());
            	    			
            	    // InternalComputerDsl.g:470:4: ( ( ruleQualifiedName ) )
            	    // InternalComputerDsl.g:471:5: ( ruleQualifiedName )
            	    {
            	    // InternalComputerDsl.g:471:5: ( ruleQualifiedName )
            	    // InternalComputerDsl.g:472:6: ruleQualifiedName
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getComputerRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getComputerAccess().getMemoryMemoryCrossReference_10_1_0());
            	    					
            	    pushFollow(FOLLOW_13);
            	    ruleQualifiedName();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_13=(Token)match(input,23,FOLLOW_4); 

            			newLeafNode(otherlv_13, grammarAccess.getComputerAccess().getStorageKeyword_11());
            		
            // InternalComputerDsl.g:491:3: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:492:4: ( ruleQualifiedName )
            {
            // InternalComputerDsl.g:492:4: ( ruleQualifiedName )
            // InternalComputerDsl.g:493:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComputerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getComputerAccess().getStorageStorageCrossReference_12_0());
            				
            pushFollow(FOLLOW_14);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalComputerDsl.g:507:3: (otherlv_15= ',' ( ( ruleQualifiedName ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==22) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalComputerDsl.g:508:4: otherlv_15= ',' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_15=(Token)match(input,22,FOLLOW_4); 

            	    				newLeafNode(otherlv_15, grammarAccess.getComputerAccess().getCommaKeyword_13_0());
            	    			
            	    // InternalComputerDsl.g:512:4: ( ( ruleQualifiedName ) )
            	    // InternalComputerDsl.g:513:5: ( ruleQualifiedName )
            	    {
            	    // InternalComputerDsl.g:513:5: ( ruleQualifiedName )
            	    // InternalComputerDsl.g:514:6: ruleQualifiedName
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getComputerRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getComputerAccess().getStorageStorageCrossReference_13_1_0());
            	    					
            	    pushFollow(FOLLOW_14);
            	    ruleQualifiedName();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalComputerDsl.g:529:3: (otherlv_17= 'drive' ( ( ruleQualifiedName ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalComputerDsl.g:530:4: otherlv_17= 'drive' ( ( ruleQualifiedName ) )
                    {
                    otherlv_17=(Token)match(input,24,FOLLOW_4); 

                    				newLeafNode(otherlv_17, grammarAccess.getComputerAccess().getDriveKeyword_14_0());
                    			
                    // InternalComputerDsl.g:534:4: ( ( ruleQualifiedName ) )
                    // InternalComputerDsl.g:535:5: ( ruleQualifiedName )
                    {
                    // InternalComputerDsl.g:535:5: ( ruleQualifiedName )
                    // InternalComputerDsl.g:536:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComputerRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getComputerAccess().getDriveDriveCrossReference_14_1_0());
                    					
                    pushFollow(FOLLOW_15);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalComputerDsl.g:551:3: (otherlv_19= 'peripherals' ( ( ruleQualifiedName ) ) (otherlv_21= ',' ( ( ruleQualifiedName ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalComputerDsl.g:552:4: otherlv_19= 'peripherals' ( ( ruleQualifiedName ) ) (otherlv_21= ',' ( ( ruleQualifiedName ) ) )*
                    {
                    otherlv_19=(Token)match(input,25,FOLLOW_4); 

                    				newLeafNode(otherlv_19, grammarAccess.getComputerAccess().getPeripheralsKeyword_15_0());
                    			
                    // InternalComputerDsl.g:556:4: ( ( ruleQualifiedName ) )
                    // InternalComputerDsl.g:557:5: ( ruleQualifiedName )
                    {
                    // InternalComputerDsl.g:557:5: ( ruleQualifiedName )
                    // InternalComputerDsl.g:558:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComputerRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getComputerAccess().getPeripheralsPeripheralCrossReference_15_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalComputerDsl.g:572:4: (otherlv_21= ',' ( ( ruleQualifiedName ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==22) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalComputerDsl.g:573:5: otherlv_21= ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_21=(Token)match(input,22,FOLLOW_4); 

                    	    					newLeafNode(otherlv_21, grammarAccess.getComputerAccess().getCommaKeyword_15_2_0());
                    	    				
                    	    // InternalComputerDsl.g:577:5: ( ( ruleQualifiedName ) )
                    	    // InternalComputerDsl.g:578:6: ( ruleQualifiedName )
                    	    {
                    	    // InternalComputerDsl.g:578:6: ( ruleQualifiedName )
                    	    // InternalComputerDsl.g:579:7: ruleQualifiedName
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getComputerRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getComputerAccess().getPeripheralsPeripheralCrossReference_15_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_16);
                    	    ruleQualifiedName();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_23=(Token)match(input,26,FOLLOW_4); 

            			newLeafNode(otherlv_23, grammarAccess.getComputerAccess().getPsuKeyword_16());
            		
            // InternalComputerDsl.g:599:3: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:600:4: ( ruleQualifiedName )
            {
            // InternalComputerDsl.g:600:4: ( ruleQualifiedName )
            // InternalComputerDsl.g:601:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComputerRule());
            					}
            				

            					newCompositeNode(grammarAccess.getComputerAccess().getPowerSupplyPowerSupplyCrossReference_17_0());
            				
            pushFollow(FOLLOW_17);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_25=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_25, grammarAccess.getComputerAccess().getRightCurlyBracketKeyword_18());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComputer"


    // $ANTLR start "entryRulePart"
    // InternalComputerDsl.g:623:1: entryRulePart returns [EObject current=null] : iv_rulePart= rulePart EOF ;
    public final EObject entryRulePart() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePart = null;


        try {
            // InternalComputerDsl.g:623:45: (iv_rulePart= rulePart EOF )
            // InternalComputerDsl.g:624:2: iv_rulePart= rulePart EOF
            {
             newCompositeNode(grammarAccess.getPartRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePart=rulePart();

            state._fsp--;

             current =iv_rulePart; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePart"


    // $ANTLR start "rulePart"
    // InternalComputerDsl.g:630:1: rulePart returns [EObject current=null] : (this_Motherboard_0= ruleMotherboard | this_Processor_1= ruleProcessor | this_GraphicsCard_2= ruleGraphicsCard | this_Memory_3= ruleMemory | this_Storage_4= ruleStorage | this_Drive_5= ruleDrive | this_Peripheral_6= rulePeripheral | this_PowerSupply_7= rulePowerSupply ) ;
    public final EObject rulePart() throws RecognitionException {
        EObject current = null;

        EObject this_Motherboard_0 = null;

        EObject this_Processor_1 = null;

        EObject this_GraphicsCard_2 = null;

        EObject this_Memory_3 = null;

        EObject this_Storage_4 = null;

        EObject this_Drive_5 = null;

        EObject this_Peripheral_6 = null;

        EObject this_PowerSupply_7 = null;



        	enterRule();

        try {
            // InternalComputerDsl.g:636:2: ( (this_Motherboard_0= ruleMotherboard | this_Processor_1= ruleProcessor | this_GraphicsCard_2= ruleGraphicsCard | this_Memory_3= ruleMemory | this_Storage_4= ruleStorage | this_Drive_5= ruleDrive | this_Peripheral_6= rulePeripheral | this_PowerSupply_7= rulePowerSupply ) )
            // InternalComputerDsl.g:637:2: (this_Motherboard_0= ruleMotherboard | this_Processor_1= ruleProcessor | this_GraphicsCard_2= ruleGraphicsCard | this_Memory_3= ruleMemory | this_Storage_4= ruleStorage | this_Drive_5= ruleDrive | this_Peripheral_6= rulePeripheral | this_PowerSupply_7= rulePowerSupply )
            {
            // InternalComputerDsl.g:637:2: (this_Motherboard_0= ruleMotherboard | this_Processor_1= ruleProcessor | this_GraphicsCard_2= ruleGraphicsCard | this_Memory_3= ruleMemory | this_Storage_4= ruleStorage | this_Drive_5= ruleDrive | this_Peripheral_6= rulePeripheral | this_PowerSupply_7= rulePowerSupply )
            int alt12=8;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt12=1;
                }
                break;
            case 19:
                {
                alt12=2;
                }
                break;
            case 20:
                {
                alt12=3;
                }
                break;
            case 21:
                {
                alt12=4;
                }
                break;
            case 23:
                {
                alt12=5;
                }
                break;
            case 24:
                {
                alt12=6;
                }
                break;
            case 38:
            case 39:
            case 40:
            case 41:
                {
                alt12=7;
                }
                break;
            case 26:
                {
                alt12=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalComputerDsl.g:638:3: this_Motherboard_0= ruleMotherboard
                    {

                    			newCompositeNode(grammarAccess.getPartAccess().getMotherboardParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Motherboard_0=ruleMotherboard();

                    state._fsp--;


                    			current = this_Motherboard_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:647:3: this_Processor_1= ruleProcessor
                    {

                    			newCompositeNode(grammarAccess.getPartAccess().getProcessorParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Processor_1=ruleProcessor();

                    state._fsp--;


                    			current = this_Processor_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalComputerDsl.g:656:3: this_GraphicsCard_2= ruleGraphicsCard
                    {

                    			newCompositeNode(grammarAccess.getPartAccess().getGraphicsCardParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_GraphicsCard_2=ruleGraphicsCard();

                    state._fsp--;


                    			current = this_GraphicsCard_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalComputerDsl.g:665:3: this_Memory_3= ruleMemory
                    {

                    			newCompositeNode(grammarAccess.getPartAccess().getMemoryParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Memory_3=ruleMemory();

                    state._fsp--;


                    			current = this_Memory_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalComputerDsl.g:674:3: this_Storage_4= ruleStorage
                    {

                    			newCompositeNode(grammarAccess.getPartAccess().getStorageParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Storage_4=ruleStorage();

                    state._fsp--;


                    			current = this_Storage_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalComputerDsl.g:683:3: this_Drive_5= ruleDrive
                    {

                    			newCompositeNode(grammarAccess.getPartAccess().getDriveParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Drive_5=ruleDrive();

                    state._fsp--;


                    			current = this_Drive_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalComputerDsl.g:692:3: this_Peripheral_6= rulePeripheral
                    {

                    			newCompositeNode(grammarAccess.getPartAccess().getPeripheralParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Peripheral_6=rulePeripheral();

                    state._fsp--;


                    			current = this_Peripheral_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalComputerDsl.g:701:3: this_PowerSupply_7= rulePowerSupply
                    {

                    			newCompositeNode(grammarAccess.getPartAccess().getPowerSupplyParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_PowerSupply_7=rulePowerSupply();

                    state._fsp--;


                    			current = this_PowerSupply_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePart"


    // $ANTLR start "entryRuleMotherboard"
    // InternalComputerDsl.g:713:1: entryRuleMotherboard returns [EObject current=null] : iv_ruleMotherboard= ruleMotherboard EOF ;
    public final EObject entryRuleMotherboard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMotherboard = null;


        try {
            // InternalComputerDsl.g:713:52: (iv_ruleMotherboard= ruleMotherboard EOF )
            // InternalComputerDsl.g:714:2: iv_ruleMotherboard= ruleMotherboard EOF
            {
             newCompositeNode(grammarAccess.getMotherboardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMotherboard=ruleMotherboard();

            state._fsp--;

             current =iv_ruleMotherboard; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMotherboard"


    // $ANTLR start "ruleMotherboard"
    // InternalComputerDsl.g:720:1: ruleMotherboard returns [EObject current=null] : (otherlv_0= 'motherboard' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleMotherboardType ) ) otherlv_7= 'chipset' ( (lv_chipset_8_0= RULE_STRING ) ) otherlv_9= 'socket' ( (lv_socket_10_0= ruleSocket ) ) (otherlv_11= 'ports' ( (lv_ports_12_0= rulePort ) ) (otherlv_13= ',' ( (lv_ports_14_0= rulePort ) ) )* )? otherlv_15= '}' ) ;
    public final EObject ruleMotherboard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_power_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_chipset_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Enumerator lv_type_6_0 = null;

        Enumerator lv_socket_10_0 = null;

        Enumerator lv_ports_12_0 = null;

        Enumerator lv_ports_14_0 = null;



        	enterRule();

        try {
            // InternalComputerDsl.g:726:2: ( (otherlv_0= 'motherboard' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleMotherboardType ) ) otherlv_7= 'chipset' ( (lv_chipset_8_0= RULE_STRING ) ) otherlv_9= 'socket' ( (lv_socket_10_0= ruleSocket ) ) (otherlv_11= 'ports' ( (lv_ports_12_0= rulePort ) ) (otherlv_13= ',' ( (lv_ports_14_0= rulePort ) ) )* )? otherlv_15= '}' ) )
            // InternalComputerDsl.g:727:2: (otherlv_0= 'motherboard' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleMotherboardType ) ) otherlv_7= 'chipset' ( (lv_chipset_8_0= RULE_STRING ) ) otherlv_9= 'socket' ( (lv_socket_10_0= ruleSocket ) ) (otherlv_11= 'ports' ( (lv_ports_12_0= rulePort ) ) (otherlv_13= ',' ( (lv_ports_14_0= rulePort ) ) )* )? otherlv_15= '}' )
            {
            // InternalComputerDsl.g:727:2: (otherlv_0= 'motherboard' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleMotherboardType ) ) otherlv_7= 'chipset' ( (lv_chipset_8_0= RULE_STRING ) ) otherlv_9= 'socket' ( (lv_socket_10_0= ruleSocket ) ) (otherlv_11= 'ports' ( (lv_ports_12_0= rulePort ) ) (otherlv_13= ',' ( (lv_ports_14_0= rulePort ) ) )* )? otherlv_15= '}' )
            // InternalComputerDsl.g:728:3: otherlv_0= 'motherboard' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleMotherboardType ) ) otherlv_7= 'chipset' ( (lv_chipset_8_0= RULE_STRING ) ) otherlv_9= 'socket' ( (lv_socket_10_0= ruleSocket ) ) (otherlv_11= 'ports' ( (lv_ports_12_0= rulePort ) ) (otherlv_13= ',' ( (lv_ports_14_0= rulePort ) ) )* )? otherlv_15= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getMotherboardAccess().getMotherboardKeyword_0());
            		
            // InternalComputerDsl.g:732:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalComputerDsl.g:733:4: (lv_name_1_0= RULE_ID )
            {
            // InternalComputerDsl.g:733:4: (lv_name_1_0= RULE_ID )
            // InternalComputerDsl.g:734:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getMotherboardAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMotherboardRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getMotherboardAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,27,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getMotherboardAccess().getPowerKeyword_3());
            		
            // InternalComputerDsl.g:758:3: ( (lv_power_4_0= RULE_INT ) )
            // InternalComputerDsl.g:759:4: (lv_power_4_0= RULE_INT )
            {
            // InternalComputerDsl.g:759:4: (lv_power_4_0= RULE_INT )
            // InternalComputerDsl.g:760:5: lv_power_4_0= RULE_INT
            {
            lv_power_4_0=(Token)match(input,RULE_INT,FOLLOW_20); 

            					newLeafNode(lv_power_4_0, grammarAccess.getMotherboardAccess().getPowerINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMotherboardRule());
            					}
            					setWithLastConsumed(
            						current,
            						"power",
            						lv_power_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,28,FOLLOW_21); 

            			newLeafNode(otherlv_5, grammarAccess.getMotherboardAccess().getTypeKeyword_5());
            		
            // InternalComputerDsl.g:780:3: ( (lv_type_6_0= ruleMotherboardType ) )
            // InternalComputerDsl.g:781:4: (lv_type_6_0= ruleMotherboardType )
            {
            // InternalComputerDsl.g:781:4: (lv_type_6_0= ruleMotherboardType )
            // InternalComputerDsl.g:782:5: lv_type_6_0= ruleMotherboardType
            {

            					newCompositeNode(grammarAccess.getMotherboardAccess().getTypeMotherboardTypeEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_22);
            lv_type_6_0=ruleMotherboardType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMotherboardRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_6_0,
            						"org.xtext.example.computer.ComputerDsl.MotherboardType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,29,FOLLOW_23); 

            			newLeafNode(otherlv_7, grammarAccess.getMotherboardAccess().getChipsetKeyword_7());
            		
            // InternalComputerDsl.g:803:3: ( (lv_chipset_8_0= RULE_STRING ) )
            // InternalComputerDsl.g:804:4: (lv_chipset_8_0= RULE_STRING )
            {
            // InternalComputerDsl.g:804:4: (lv_chipset_8_0= RULE_STRING )
            // InternalComputerDsl.g:805:5: lv_chipset_8_0= RULE_STRING
            {
            lv_chipset_8_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

            					newLeafNode(lv_chipset_8_0, grammarAccess.getMotherboardAccess().getChipsetSTRINGTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMotherboardRule());
            					}
            					setWithLastConsumed(
            						current,
            						"chipset",
            						lv_chipset_8_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_9=(Token)match(input,30,FOLLOW_25); 

            			newLeafNode(otherlv_9, grammarAccess.getMotherboardAccess().getSocketKeyword_9());
            		
            // InternalComputerDsl.g:825:3: ( (lv_socket_10_0= ruleSocket ) )
            // InternalComputerDsl.g:826:4: (lv_socket_10_0= ruleSocket )
            {
            // InternalComputerDsl.g:826:4: (lv_socket_10_0= ruleSocket )
            // InternalComputerDsl.g:827:5: lv_socket_10_0= ruleSocket
            {

            					newCompositeNode(grammarAccess.getMotherboardAccess().getSocketSocketEnumRuleCall_10_0());
            				
            pushFollow(FOLLOW_26);
            lv_socket_10_0=ruleSocket();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMotherboardRule());
            					}
            					set(
            						current,
            						"socket",
            						lv_socket_10_0,
            						"org.xtext.example.computer.ComputerDsl.Socket");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalComputerDsl.g:844:3: (otherlv_11= 'ports' ( (lv_ports_12_0= rulePort ) ) (otherlv_13= ',' ( (lv_ports_14_0= rulePort ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==31) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalComputerDsl.g:845:4: otherlv_11= 'ports' ( (lv_ports_12_0= rulePort ) ) (otherlv_13= ',' ( (lv_ports_14_0= rulePort ) ) )*
                    {
                    otherlv_11=(Token)match(input,31,FOLLOW_27); 

                    				newLeafNode(otherlv_11, grammarAccess.getMotherboardAccess().getPortsKeyword_11_0());
                    			
                    // InternalComputerDsl.g:849:4: ( (lv_ports_12_0= rulePort ) )
                    // InternalComputerDsl.g:850:5: (lv_ports_12_0= rulePort )
                    {
                    // InternalComputerDsl.g:850:5: (lv_ports_12_0= rulePort )
                    // InternalComputerDsl.g:851:6: lv_ports_12_0= rulePort
                    {

                    						newCompositeNode(grammarAccess.getMotherboardAccess().getPortsPortEnumRuleCall_11_1_0());
                    					
                    pushFollow(FOLLOW_28);
                    lv_ports_12_0=rulePort();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMotherboardRule());
                    						}
                    						add(
                    							current,
                    							"ports",
                    							lv_ports_12_0,
                    							"org.xtext.example.computer.ComputerDsl.Port");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalComputerDsl.g:868:4: (otherlv_13= ',' ( (lv_ports_14_0= rulePort ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==22) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalComputerDsl.g:869:5: otherlv_13= ',' ( (lv_ports_14_0= rulePort ) )
                    	    {
                    	    otherlv_13=(Token)match(input,22,FOLLOW_27); 

                    	    					newLeafNode(otherlv_13, grammarAccess.getMotherboardAccess().getCommaKeyword_11_2_0());
                    	    				
                    	    // InternalComputerDsl.g:873:5: ( (lv_ports_14_0= rulePort ) )
                    	    // InternalComputerDsl.g:874:6: (lv_ports_14_0= rulePort )
                    	    {
                    	    // InternalComputerDsl.g:874:6: (lv_ports_14_0= rulePort )
                    	    // InternalComputerDsl.g:875:7: lv_ports_14_0= rulePort
                    	    {

                    	    							newCompositeNode(grammarAccess.getMotherboardAccess().getPortsPortEnumRuleCall_11_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_28);
                    	    lv_ports_14_0=rulePort();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getMotherboardRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"ports",
                    	    								lv_ports_14_0,
                    	    								"org.xtext.example.computer.ComputerDsl.Port");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_15=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_15, grammarAccess.getMotherboardAccess().getRightCurlyBracketKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMotherboard"


    // $ANTLR start "entryRuleProcessor"
    // InternalComputerDsl.g:902:1: entryRuleProcessor returns [EObject current=null] : iv_ruleProcessor= ruleProcessor EOF ;
    public final EObject entryRuleProcessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessor = null;


        try {
            // InternalComputerDsl.g:902:50: (iv_ruleProcessor= ruleProcessor EOF )
            // InternalComputerDsl.g:903:2: iv_ruleProcessor= ruleProcessor EOF
            {
             newCompositeNode(grammarAccess.getProcessorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProcessor=ruleProcessor();

            state._fsp--;

             current =iv_ruleProcessor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcessor"


    // $ANTLR start "ruleProcessor"
    // InternalComputerDsl.g:909:1: ruleProcessor returns [EObject current=null] : (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) (otherlv_5= 'model' ( (lv_model_6_0= RULE_STRING ) ) )? otherlv_7= 'socket' ( (lv_socket_8_0= ruleSocket ) ) otherlv_9= 'cores' ( (lv_cores_10_0= RULE_INT ) ) otherlv_11= '}' ) ;
    public final EObject ruleProcessor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_power_4_0=null;
        Token otherlv_5=null;
        Token lv_model_6_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token lv_cores_10_0=null;
        Token otherlv_11=null;
        Enumerator lv_socket_8_0 = null;



        	enterRule();

        try {
            // InternalComputerDsl.g:915:2: ( (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) (otherlv_5= 'model' ( (lv_model_6_0= RULE_STRING ) ) )? otherlv_7= 'socket' ( (lv_socket_8_0= ruleSocket ) ) otherlv_9= 'cores' ( (lv_cores_10_0= RULE_INT ) ) otherlv_11= '}' ) )
            // InternalComputerDsl.g:916:2: (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) (otherlv_5= 'model' ( (lv_model_6_0= RULE_STRING ) ) )? otherlv_7= 'socket' ( (lv_socket_8_0= ruleSocket ) ) otherlv_9= 'cores' ( (lv_cores_10_0= RULE_INT ) ) otherlv_11= '}' )
            {
            // InternalComputerDsl.g:916:2: (otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) (otherlv_5= 'model' ( (lv_model_6_0= RULE_STRING ) ) )? otherlv_7= 'socket' ( (lv_socket_8_0= ruleSocket ) ) otherlv_9= 'cores' ( (lv_cores_10_0= RULE_INT ) ) otherlv_11= '}' )
            // InternalComputerDsl.g:917:3: otherlv_0= 'processor' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) (otherlv_5= 'model' ( (lv_model_6_0= RULE_STRING ) ) )? otherlv_7= 'socket' ( (lv_socket_8_0= ruleSocket ) ) otherlv_9= 'cores' ( (lv_cores_10_0= RULE_INT ) ) otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getProcessorAccess().getProcessorKeyword_0());
            		
            // InternalComputerDsl.g:921:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalComputerDsl.g:922:4: (lv_name_1_0= RULE_ID )
            {
            // InternalComputerDsl.g:922:4: (lv_name_1_0= RULE_ID )
            // InternalComputerDsl.g:923:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getProcessorAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProcessorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getProcessorAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,27,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getProcessorAccess().getPowerKeyword_3());
            		
            // InternalComputerDsl.g:947:3: ( (lv_power_4_0= RULE_INT ) )
            // InternalComputerDsl.g:948:4: (lv_power_4_0= RULE_INT )
            {
            // InternalComputerDsl.g:948:4: (lv_power_4_0= RULE_INT )
            // InternalComputerDsl.g:949:5: lv_power_4_0= RULE_INT
            {
            lv_power_4_0=(Token)match(input,RULE_INT,FOLLOW_29); 

            					newLeafNode(lv_power_4_0, grammarAccess.getProcessorAccess().getPowerINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProcessorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"power",
            						lv_power_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalComputerDsl.g:965:3: (otherlv_5= 'model' ( (lv_model_6_0= RULE_STRING ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==32) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalComputerDsl.g:966:4: otherlv_5= 'model' ( (lv_model_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,32,FOLLOW_23); 

                    				newLeafNode(otherlv_5, grammarAccess.getProcessorAccess().getModelKeyword_5_0());
                    			
                    // InternalComputerDsl.g:970:4: ( (lv_model_6_0= RULE_STRING ) )
                    // InternalComputerDsl.g:971:5: (lv_model_6_0= RULE_STRING )
                    {
                    // InternalComputerDsl.g:971:5: (lv_model_6_0= RULE_STRING )
                    // InternalComputerDsl.g:972:6: lv_model_6_0= RULE_STRING
                    {
                    lv_model_6_0=(Token)match(input,RULE_STRING,FOLLOW_24); 

                    						newLeafNode(lv_model_6_0, grammarAccess.getProcessorAccess().getModelSTRINGTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getProcessorRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"model",
                    							lv_model_6_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,30,FOLLOW_25); 

            			newLeafNode(otherlv_7, grammarAccess.getProcessorAccess().getSocketKeyword_6());
            		
            // InternalComputerDsl.g:993:3: ( (lv_socket_8_0= ruleSocket ) )
            // InternalComputerDsl.g:994:4: (lv_socket_8_0= ruleSocket )
            {
            // InternalComputerDsl.g:994:4: (lv_socket_8_0= ruleSocket )
            // InternalComputerDsl.g:995:5: lv_socket_8_0= ruleSocket
            {

            					newCompositeNode(grammarAccess.getProcessorAccess().getSocketSocketEnumRuleCall_7_0());
            				
            pushFollow(FOLLOW_30);
            lv_socket_8_0=ruleSocket();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProcessorRule());
            					}
            					set(
            						current,
            						"socket",
            						lv_socket_8_0,
            						"org.xtext.example.computer.ComputerDsl.Socket");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,33,FOLLOW_19); 

            			newLeafNode(otherlv_9, grammarAccess.getProcessorAccess().getCoresKeyword_8());
            		
            // InternalComputerDsl.g:1016:3: ( (lv_cores_10_0= RULE_INT ) )
            // InternalComputerDsl.g:1017:4: (lv_cores_10_0= RULE_INT )
            {
            // InternalComputerDsl.g:1017:4: (lv_cores_10_0= RULE_INT )
            // InternalComputerDsl.g:1018:5: lv_cores_10_0= RULE_INT
            {
            lv_cores_10_0=(Token)match(input,RULE_INT,FOLLOW_17); 

            					newLeafNode(lv_cores_10_0, grammarAccess.getProcessorAccess().getCoresINTTerminalRuleCall_9_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getProcessorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"cores",
            						lv_cores_10_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_11=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getProcessorAccess().getRightCurlyBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcessor"


    // $ANTLR start "entryRuleGraphicsCard"
    // InternalComputerDsl.g:1042:1: entryRuleGraphicsCard returns [EObject current=null] : iv_ruleGraphicsCard= ruleGraphicsCard EOF ;
    public final EObject entryRuleGraphicsCard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGraphicsCard = null;


        try {
            // InternalComputerDsl.g:1042:53: (iv_ruleGraphicsCard= ruleGraphicsCard EOF )
            // InternalComputerDsl.g:1043:2: iv_ruleGraphicsCard= ruleGraphicsCard EOF
            {
             newCompositeNode(grammarAccess.getGraphicsCardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGraphicsCard=ruleGraphicsCard();

            state._fsp--;

             current =iv_ruleGraphicsCard; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGraphicsCard"


    // $ANTLR start "ruleGraphicsCard"
    // InternalComputerDsl.g:1049:1: ruleGraphicsCard returns [EObject current=null] : (otherlv_0= 'graphics' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) (otherlv_5= 'model' ( (lv_model_6_0= RULE_STRING ) ) )? otherlv_7= 'vram' ( (lv_vram_8_0= RULE_INT ) ) otherlv_9= '}' ) ;
    public final EObject ruleGraphicsCard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_power_4_0=null;
        Token otherlv_5=null;
        Token lv_model_6_0=null;
        Token otherlv_7=null;
        Token lv_vram_8_0=null;
        Token otherlv_9=null;


        	enterRule();

        try {
            // InternalComputerDsl.g:1055:2: ( (otherlv_0= 'graphics' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) (otherlv_5= 'model' ( (lv_model_6_0= RULE_STRING ) ) )? otherlv_7= 'vram' ( (lv_vram_8_0= RULE_INT ) ) otherlv_9= '}' ) )
            // InternalComputerDsl.g:1056:2: (otherlv_0= 'graphics' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) (otherlv_5= 'model' ( (lv_model_6_0= RULE_STRING ) ) )? otherlv_7= 'vram' ( (lv_vram_8_0= RULE_INT ) ) otherlv_9= '}' )
            {
            // InternalComputerDsl.g:1056:2: (otherlv_0= 'graphics' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) (otherlv_5= 'model' ( (lv_model_6_0= RULE_STRING ) ) )? otherlv_7= 'vram' ( (lv_vram_8_0= RULE_INT ) ) otherlv_9= '}' )
            // InternalComputerDsl.g:1057:3: otherlv_0= 'graphics' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) (otherlv_5= 'model' ( (lv_model_6_0= RULE_STRING ) ) )? otherlv_7= 'vram' ( (lv_vram_8_0= RULE_INT ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getGraphicsCardAccess().getGraphicsKeyword_0());
            		
            // InternalComputerDsl.g:1061:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalComputerDsl.g:1062:4: (lv_name_1_0= RULE_ID )
            {
            // InternalComputerDsl.g:1062:4: (lv_name_1_0= RULE_ID )
            // InternalComputerDsl.g:1063:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getGraphicsCardAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGraphicsCardRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getGraphicsCardAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,27,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getGraphicsCardAccess().getPowerKeyword_3());
            		
            // InternalComputerDsl.g:1087:3: ( (lv_power_4_0= RULE_INT ) )
            // InternalComputerDsl.g:1088:4: (lv_power_4_0= RULE_INT )
            {
            // InternalComputerDsl.g:1088:4: (lv_power_4_0= RULE_INT )
            // InternalComputerDsl.g:1089:5: lv_power_4_0= RULE_INT
            {
            lv_power_4_0=(Token)match(input,RULE_INT,FOLLOW_31); 

            					newLeafNode(lv_power_4_0, grammarAccess.getGraphicsCardAccess().getPowerINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGraphicsCardRule());
            					}
            					setWithLastConsumed(
            						current,
            						"power",
            						lv_power_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalComputerDsl.g:1105:3: (otherlv_5= 'model' ( (lv_model_6_0= RULE_STRING ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==32) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalComputerDsl.g:1106:4: otherlv_5= 'model' ( (lv_model_6_0= RULE_STRING ) )
                    {
                    otherlv_5=(Token)match(input,32,FOLLOW_23); 

                    				newLeafNode(otherlv_5, grammarAccess.getGraphicsCardAccess().getModelKeyword_5_0());
                    			
                    // InternalComputerDsl.g:1110:4: ( (lv_model_6_0= RULE_STRING ) )
                    // InternalComputerDsl.g:1111:5: (lv_model_6_0= RULE_STRING )
                    {
                    // InternalComputerDsl.g:1111:5: (lv_model_6_0= RULE_STRING )
                    // InternalComputerDsl.g:1112:6: lv_model_6_0= RULE_STRING
                    {
                    lv_model_6_0=(Token)match(input,RULE_STRING,FOLLOW_32); 

                    						newLeafNode(lv_model_6_0, grammarAccess.getGraphicsCardAccess().getModelSTRINGTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getGraphicsCardRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"model",
                    							lv_model_6_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,34,FOLLOW_19); 

            			newLeafNode(otherlv_7, grammarAccess.getGraphicsCardAccess().getVramKeyword_6());
            		
            // InternalComputerDsl.g:1133:3: ( (lv_vram_8_0= RULE_INT ) )
            // InternalComputerDsl.g:1134:4: (lv_vram_8_0= RULE_INT )
            {
            // InternalComputerDsl.g:1134:4: (lv_vram_8_0= RULE_INT )
            // InternalComputerDsl.g:1135:5: lv_vram_8_0= RULE_INT
            {
            lv_vram_8_0=(Token)match(input,RULE_INT,FOLLOW_17); 

            					newLeafNode(lv_vram_8_0, grammarAccess.getGraphicsCardAccess().getVramINTTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGraphicsCardRule());
            					}
            					setWithLastConsumed(
            						current,
            						"vram",
            						lv_vram_8_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getGraphicsCardAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGraphicsCard"


    // $ANTLR start "entryRuleMemory"
    // InternalComputerDsl.g:1159:1: entryRuleMemory returns [EObject current=null] : iv_ruleMemory= ruleMemory EOF ;
    public final EObject entryRuleMemory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMemory = null;


        try {
            // InternalComputerDsl.g:1159:47: (iv_ruleMemory= ruleMemory EOF )
            // InternalComputerDsl.g:1160:2: iv_ruleMemory= ruleMemory EOF
            {
             newCompositeNode(grammarAccess.getMemoryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMemory=ruleMemory();

            state._fsp--;

             current =iv_ruleMemory; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMemory"


    // $ANTLR start "ruleMemory"
    // InternalComputerDsl.g:1166:1: ruleMemory returns [EObject current=null] : (otherlv_0= 'memory' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleMemoryType ) ) otherlv_7= 'capacity' ( (lv_capacity_8_0= RULE_INT ) ) otherlv_9= '}' ) ;
    public final EObject ruleMemory() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_power_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_capacity_8_0=null;
        Token otherlv_9=null;
        Enumerator lv_type_6_0 = null;



        	enterRule();

        try {
            // InternalComputerDsl.g:1172:2: ( (otherlv_0= 'memory' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleMemoryType ) ) otherlv_7= 'capacity' ( (lv_capacity_8_0= RULE_INT ) ) otherlv_9= '}' ) )
            // InternalComputerDsl.g:1173:2: (otherlv_0= 'memory' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleMemoryType ) ) otherlv_7= 'capacity' ( (lv_capacity_8_0= RULE_INT ) ) otherlv_9= '}' )
            {
            // InternalComputerDsl.g:1173:2: (otherlv_0= 'memory' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleMemoryType ) ) otherlv_7= 'capacity' ( (lv_capacity_8_0= RULE_INT ) ) otherlv_9= '}' )
            // InternalComputerDsl.g:1174:3: otherlv_0= 'memory' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleMemoryType ) ) otherlv_7= 'capacity' ( (lv_capacity_8_0= RULE_INT ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getMemoryAccess().getMemoryKeyword_0());
            		
            // InternalComputerDsl.g:1178:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalComputerDsl.g:1179:4: (lv_name_1_0= RULE_ID )
            {
            // InternalComputerDsl.g:1179:4: (lv_name_1_0= RULE_ID )
            // InternalComputerDsl.g:1180:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getMemoryAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMemoryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getMemoryAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,27,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getMemoryAccess().getPowerKeyword_3());
            		
            // InternalComputerDsl.g:1204:3: ( (lv_power_4_0= RULE_INT ) )
            // InternalComputerDsl.g:1205:4: (lv_power_4_0= RULE_INT )
            {
            // InternalComputerDsl.g:1205:4: (lv_power_4_0= RULE_INT )
            // InternalComputerDsl.g:1206:5: lv_power_4_0= RULE_INT
            {
            lv_power_4_0=(Token)match(input,RULE_INT,FOLLOW_20); 

            					newLeafNode(lv_power_4_0, grammarAccess.getMemoryAccess().getPowerINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMemoryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"power",
            						lv_power_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,28,FOLLOW_33); 

            			newLeafNode(otherlv_5, grammarAccess.getMemoryAccess().getTypeKeyword_5());
            		
            // InternalComputerDsl.g:1226:3: ( (lv_type_6_0= ruleMemoryType ) )
            // InternalComputerDsl.g:1227:4: (lv_type_6_0= ruleMemoryType )
            {
            // InternalComputerDsl.g:1227:4: (lv_type_6_0= ruleMemoryType )
            // InternalComputerDsl.g:1228:5: lv_type_6_0= ruleMemoryType
            {

            					newCompositeNode(grammarAccess.getMemoryAccess().getTypeMemoryTypeEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_34);
            lv_type_6_0=ruleMemoryType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMemoryRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_6_0,
            						"org.xtext.example.computer.ComputerDsl.MemoryType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,35,FOLLOW_19); 

            			newLeafNode(otherlv_7, grammarAccess.getMemoryAccess().getCapacityKeyword_7());
            		
            // InternalComputerDsl.g:1249:3: ( (lv_capacity_8_0= RULE_INT ) )
            // InternalComputerDsl.g:1250:4: (lv_capacity_8_0= RULE_INT )
            {
            // InternalComputerDsl.g:1250:4: (lv_capacity_8_0= RULE_INT )
            // InternalComputerDsl.g:1251:5: lv_capacity_8_0= RULE_INT
            {
            lv_capacity_8_0=(Token)match(input,RULE_INT,FOLLOW_17); 

            					newLeafNode(lv_capacity_8_0, grammarAccess.getMemoryAccess().getCapacityINTTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMemoryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"capacity",
            						lv_capacity_8_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getMemoryAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMemory"


    // $ANTLR start "entryRuleStorage"
    // InternalComputerDsl.g:1275:1: entryRuleStorage returns [EObject current=null] : iv_ruleStorage= ruleStorage EOF ;
    public final EObject entryRuleStorage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStorage = null;


        try {
            // InternalComputerDsl.g:1275:48: (iv_ruleStorage= ruleStorage EOF )
            // InternalComputerDsl.g:1276:2: iv_ruleStorage= ruleStorage EOF
            {
             newCompositeNode(grammarAccess.getStorageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStorage=ruleStorage();

            state._fsp--;

             current =iv_ruleStorage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStorage"


    // $ANTLR start "ruleStorage"
    // InternalComputerDsl.g:1282:1: ruleStorage returns [EObject current=null] : (otherlv_0= 'storage' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleStorageType ) ) otherlv_7= 'capacity' ( (lv_capacity_8_0= RULE_INT ) ) otherlv_9= '}' ) ;
    public final EObject ruleStorage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_power_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_capacity_8_0=null;
        Token otherlv_9=null;
        Enumerator lv_type_6_0 = null;



        	enterRule();

        try {
            // InternalComputerDsl.g:1288:2: ( (otherlv_0= 'storage' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleStorageType ) ) otherlv_7= 'capacity' ( (lv_capacity_8_0= RULE_INT ) ) otherlv_9= '}' ) )
            // InternalComputerDsl.g:1289:2: (otherlv_0= 'storage' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleStorageType ) ) otherlv_7= 'capacity' ( (lv_capacity_8_0= RULE_INT ) ) otherlv_9= '}' )
            {
            // InternalComputerDsl.g:1289:2: (otherlv_0= 'storage' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleStorageType ) ) otherlv_7= 'capacity' ( (lv_capacity_8_0= RULE_INT ) ) otherlv_9= '}' )
            // InternalComputerDsl.g:1290:3: otherlv_0= 'storage' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleStorageType ) ) otherlv_7= 'capacity' ( (lv_capacity_8_0= RULE_INT ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getStorageAccess().getStorageKeyword_0());
            		
            // InternalComputerDsl.g:1294:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalComputerDsl.g:1295:4: (lv_name_1_0= RULE_ID )
            {
            // InternalComputerDsl.g:1295:4: (lv_name_1_0= RULE_ID )
            // InternalComputerDsl.g:1296:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getStorageAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getStorageAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,27,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getStorageAccess().getPowerKeyword_3());
            		
            // InternalComputerDsl.g:1320:3: ( (lv_power_4_0= RULE_INT ) )
            // InternalComputerDsl.g:1321:4: (lv_power_4_0= RULE_INT )
            {
            // InternalComputerDsl.g:1321:4: (lv_power_4_0= RULE_INT )
            // InternalComputerDsl.g:1322:5: lv_power_4_0= RULE_INT
            {
            lv_power_4_0=(Token)match(input,RULE_INT,FOLLOW_20); 

            					newLeafNode(lv_power_4_0, grammarAccess.getStorageAccess().getPowerINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"power",
            						lv_power_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,28,FOLLOW_35); 

            			newLeafNode(otherlv_5, grammarAccess.getStorageAccess().getTypeKeyword_5());
            		
            // InternalComputerDsl.g:1342:3: ( (lv_type_6_0= ruleStorageType ) )
            // InternalComputerDsl.g:1343:4: (lv_type_6_0= ruleStorageType )
            {
            // InternalComputerDsl.g:1343:4: (lv_type_6_0= ruleStorageType )
            // InternalComputerDsl.g:1344:5: lv_type_6_0= ruleStorageType
            {

            					newCompositeNode(grammarAccess.getStorageAccess().getTypeStorageTypeEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_34);
            lv_type_6_0=ruleStorageType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStorageRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_6_0,
            						"org.xtext.example.computer.ComputerDsl.StorageType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,35,FOLLOW_19); 

            			newLeafNode(otherlv_7, grammarAccess.getStorageAccess().getCapacityKeyword_7());
            		
            // InternalComputerDsl.g:1365:3: ( (lv_capacity_8_0= RULE_INT ) )
            // InternalComputerDsl.g:1366:4: (lv_capacity_8_0= RULE_INT )
            {
            // InternalComputerDsl.g:1366:4: (lv_capacity_8_0= RULE_INT )
            // InternalComputerDsl.g:1367:5: lv_capacity_8_0= RULE_INT
            {
            lv_capacity_8_0=(Token)match(input,RULE_INT,FOLLOW_17); 

            					newLeafNode(lv_capacity_8_0, grammarAccess.getStorageAccess().getCapacityINTTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStorageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"capacity",
            						lv_capacity_8_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_9=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getStorageAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStorage"


    // $ANTLR start "entryRuleDrive"
    // InternalComputerDsl.g:1391:1: entryRuleDrive returns [EObject current=null] : iv_ruleDrive= ruleDrive EOF ;
    public final EObject entryRuleDrive() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDrive = null;


        try {
            // InternalComputerDsl.g:1391:46: (iv_ruleDrive= ruleDrive EOF )
            // InternalComputerDsl.g:1392:2: iv_ruleDrive= ruleDrive EOF
            {
             newCompositeNode(grammarAccess.getDriveRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDrive=ruleDrive();

            state._fsp--;

             current =iv_ruleDrive; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDrive"


    // $ANTLR start "ruleDrive"
    // InternalComputerDsl.g:1398:1: ruleDrive returns [EObject current=null] : (otherlv_0= 'drive' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleDriveType ) ) otherlv_7= '}' ) ;
    public final EObject ruleDrive() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_power_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_type_6_0 = null;



        	enterRule();

        try {
            // InternalComputerDsl.g:1404:2: ( (otherlv_0= 'drive' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleDriveType ) ) otherlv_7= '}' ) )
            // InternalComputerDsl.g:1405:2: (otherlv_0= 'drive' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleDriveType ) ) otherlv_7= '}' )
            {
            // InternalComputerDsl.g:1405:2: (otherlv_0= 'drive' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleDriveType ) ) otherlv_7= '}' )
            // InternalComputerDsl.g:1406:3: otherlv_0= 'drive' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'type' ( (lv_type_6_0= ruleDriveType ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDriveAccess().getDriveKeyword_0());
            		
            // InternalComputerDsl.g:1410:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalComputerDsl.g:1411:4: (lv_name_1_0= RULE_ID )
            {
            // InternalComputerDsl.g:1411:4: (lv_name_1_0= RULE_ID )
            // InternalComputerDsl.g:1412:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDriveAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDriveRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getDriveAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,27,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getDriveAccess().getPowerKeyword_3());
            		
            // InternalComputerDsl.g:1436:3: ( (lv_power_4_0= RULE_INT ) )
            // InternalComputerDsl.g:1437:4: (lv_power_4_0= RULE_INT )
            {
            // InternalComputerDsl.g:1437:4: (lv_power_4_0= RULE_INT )
            // InternalComputerDsl.g:1438:5: lv_power_4_0= RULE_INT
            {
            lv_power_4_0=(Token)match(input,RULE_INT,FOLLOW_20); 

            					newLeafNode(lv_power_4_0, grammarAccess.getDriveAccess().getPowerINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDriveRule());
            					}
            					setWithLastConsumed(
            						current,
            						"power",
            						lv_power_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,28,FOLLOW_36); 

            			newLeafNode(otherlv_5, grammarAccess.getDriveAccess().getTypeKeyword_5());
            		
            // InternalComputerDsl.g:1458:3: ( (lv_type_6_0= ruleDriveType ) )
            // InternalComputerDsl.g:1459:4: (lv_type_6_0= ruleDriveType )
            {
            // InternalComputerDsl.g:1459:4: (lv_type_6_0= ruleDriveType )
            // InternalComputerDsl.g:1460:5: lv_type_6_0= ruleDriveType
            {

            					newCompositeNode(grammarAccess.getDriveAccess().getTypeDriveTypeEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_17);
            lv_type_6_0=ruleDriveType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDriveRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_6_0,
            						"org.xtext.example.computer.ComputerDsl.DriveType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getDriveAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDrive"


    // $ANTLR start "entryRulePeripheral"
    // InternalComputerDsl.g:1485:1: entryRulePeripheral returns [EObject current=null] : iv_rulePeripheral= rulePeripheral EOF ;
    public final EObject entryRulePeripheral() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePeripheral = null;


        try {
            // InternalComputerDsl.g:1485:51: (iv_rulePeripheral= rulePeripheral EOF )
            // InternalComputerDsl.g:1486:2: iv_rulePeripheral= rulePeripheral EOF
            {
             newCompositeNode(grammarAccess.getPeripheralRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePeripheral=rulePeripheral();

            state._fsp--;

             current =iv_rulePeripheral; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePeripheral"


    // $ANTLR start "rulePeripheral"
    // InternalComputerDsl.g:1492:1: rulePeripheral returns [EObject current=null] : ( ( (lv_kind_0_0= rulePeripheralKind ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'port' ( (lv_port_6_0= rulePort ) ) otherlv_7= '}' ) ;
    public final EObject rulePeripheral() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_power_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_kind_0_0 = null;

        Enumerator lv_port_6_0 = null;



        	enterRule();

        try {
            // InternalComputerDsl.g:1498:2: ( ( ( (lv_kind_0_0= rulePeripheralKind ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'port' ( (lv_port_6_0= rulePort ) ) otherlv_7= '}' ) )
            // InternalComputerDsl.g:1499:2: ( ( (lv_kind_0_0= rulePeripheralKind ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'port' ( (lv_port_6_0= rulePort ) ) otherlv_7= '}' )
            {
            // InternalComputerDsl.g:1499:2: ( ( (lv_kind_0_0= rulePeripheralKind ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'port' ( (lv_port_6_0= rulePort ) ) otherlv_7= '}' )
            // InternalComputerDsl.g:1500:3: ( (lv_kind_0_0= rulePeripheralKind ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'power' ( (lv_power_4_0= RULE_INT ) ) otherlv_5= 'port' ( (lv_port_6_0= rulePort ) ) otherlv_7= '}'
            {
            // InternalComputerDsl.g:1500:3: ( (lv_kind_0_0= rulePeripheralKind ) )
            // InternalComputerDsl.g:1501:4: (lv_kind_0_0= rulePeripheralKind )
            {
            // InternalComputerDsl.g:1501:4: (lv_kind_0_0= rulePeripheralKind )
            // InternalComputerDsl.g:1502:5: lv_kind_0_0= rulePeripheralKind
            {

            					newCompositeNode(grammarAccess.getPeripheralAccess().getKindPeripheralKindEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_4);
            lv_kind_0_0=rulePeripheralKind();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPeripheralRule());
            					}
            					set(
            						current,
            						"kind",
            						lv_kind_0_0,
            						"org.xtext.example.computer.ComputerDsl.PeripheralKind");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalComputerDsl.g:1519:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalComputerDsl.g:1520:4: (lv_name_1_0= RULE_ID )
            {
            // InternalComputerDsl.g:1520:4: (lv_name_1_0= RULE_ID )
            // InternalComputerDsl.g:1521:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPeripheralAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPeripheralRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_18); 

            			newLeafNode(otherlv_2, grammarAccess.getPeripheralAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,27,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getPeripheralAccess().getPowerKeyword_3());
            		
            // InternalComputerDsl.g:1545:3: ( (lv_power_4_0= RULE_INT ) )
            // InternalComputerDsl.g:1546:4: (lv_power_4_0= RULE_INT )
            {
            // InternalComputerDsl.g:1546:4: (lv_power_4_0= RULE_INT )
            // InternalComputerDsl.g:1547:5: lv_power_4_0= RULE_INT
            {
            lv_power_4_0=(Token)match(input,RULE_INT,FOLLOW_37); 

            					newLeafNode(lv_power_4_0, grammarAccess.getPeripheralAccess().getPowerINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPeripheralRule());
            					}
            					setWithLastConsumed(
            						current,
            						"power",
            						lv_power_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,36,FOLLOW_27); 

            			newLeafNode(otherlv_5, grammarAccess.getPeripheralAccess().getPortKeyword_5());
            		
            // InternalComputerDsl.g:1567:3: ( (lv_port_6_0= rulePort ) )
            // InternalComputerDsl.g:1568:4: (lv_port_6_0= rulePort )
            {
            // InternalComputerDsl.g:1568:4: (lv_port_6_0= rulePort )
            // InternalComputerDsl.g:1569:5: lv_port_6_0= rulePort
            {

            					newCompositeNode(grammarAccess.getPeripheralAccess().getPortPortEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_17);
            lv_port_6_0=rulePort();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPeripheralRule());
            					}
            					set(
            						current,
            						"port",
            						lv_port_6_0,
            						"org.xtext.example.computer.ComputerDsl.Port");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getPeripheralAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePeripheral"


    // $ANTLR start "entryRulePowerSupply"
    // InternalComputerDsl.g:1594:1: entryRulePowerSupply returns [EObject current=null] : iv_rulePowerSupply= rulePowerSupply EOF ;
    public final EObject entryRulePowerSupply() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePowerSupply = null;


        try {
            // InternalComputerDsl.g:1594:52: (iv_rulePowerSupply= rulePowerSupply EOF )
            // InternalComputerDsl.g:1595:2: iv_rulePowerSupply= rulePowerSupply EOF
            {
             newCompositeNode(grammarAccess.getPowerSupplyRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePowerSupply=rulePowerSupply();

            state._fsp--;

             current =iv_rulePowerSupply; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePowerSupply"


    // $ANTLR start "rulePowerSupply"
    // InternalComputerDsl.g:1601:1: rulePowerSupply returns [EObject current=null] : (otherlv_0= 'psu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'capacity' ( (lv_capacity_4_0= RULE_INT ) ) otherlv_5= 'rating' ( (lv_rating_6_0= ruleRating ) ) otherlv_7= '}' ) ;
    public final EObject rulePowerSupply() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_capacity_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_rating_6_0 = null;



        	enterRule();

        try {
            // InternalComputerDsl.g:1607:2: ( (otherlv_0= 'psu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'capacity' ( (lv_capacity_4_0= RULE_INT ) ) otherlv_5= 'rating' ( (lv_rating_6_0= ruleRating ) ) otherlv_7= '}' ) )
            // InternalComputerDsl.g:1608:2: (otherlv_0= 'psu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'capacity' ( (lv_capacity_4_0= RULE_INT ) ) otherlv_5= 'rating' ( (lv_rating_6_0= ruleRating ) ) otherlv_7= '}' )
            {
            // InternalComputerDsl.g:1608:2: (otherlv_0= 'psu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'capacity' ( (lv_capacity_4_0= RULE_INT ) ) otherlv_5= 'rating' ( (lv_rating_6_0= ruleRating ) ) otherlv_7= '}' )
            // InternalComputerDsl.g:1609:3: otherlv_0= 'psu' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'capacity' ( (lv_capacity_4_0= RULE_INT ) ) otherlv_5= 'rating' ( (lv_rating_6_0= ruleRating ) ) otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getPowerSupplyAccess().getPsuKeyword_0());
            		
            // InternalComputerDsl.g:1613:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalComputerDsl.g:1614:4: (lv_name_1_0= RULE_ID )
            {
            // InternalComputerDsl.g:1614:4: (lv_name_1_0= RULE_ID )
            // InternalComputerDsl.g:1615:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getPowerSupplyAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerSupplyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_34); 

            			newLeafNode(otherlv_2, grammarAccess.getPowerSupplyAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_3=(Token)match(input,35,FOLLOW_19); 

            			newLeafNode(otherlv_3, grammarAccess.getPowerSupplyAccess().getCapacityKeyword_3());
            		
            // InternalComputerDsl.g:1639:3: ( (lv_capacity_4_0= RULE_INT ) )
            // InternalComputerDsl.g:1640:4: (lv_capacity_4_0= RULE_INT )
            {
            // InternalComputerDsl.g:1640:4: (lv_capacity_4_0= RULE_INT )
            // InternalComputerDsl.g:1641:5: lv_capacity_4_0= RULE_INT
            {
            lv_capacity_4_0=(Token)match(input,RULE_INT,FOLLOW_38); 

            					newLeafNode(lv_capacity_4_0, grammarAccess.getPowerSupplyAccess().getCapacityINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPowerSupplyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"capacity",
            						lv_capacity_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,37,FOLLOW_39); 

            			newLeafNode(otherlv_5, grammarAccess.getPowerSupplyAccess().getRatingKeyword_5());
            		
            // InternalComputerDsl.g:1661:3: ( (lv_rating_6_0= ruleRating ) )
            // InternalComputerDsl.g:1662:4: (lv_rating_6_0= ruleRating )
            {
            // InternalComputerDsl.g:1662:4: (lv_rating_6_0= ruleRating )
            // InternalComputerDsl.g:1663:5: lv_rating_6_0= ruleRating
            {

            					newCompositeNode(grammarAccess.getPowerSupplyAccess().getRatingRatingEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_17);
            lv_rating_6_0=ruleRating();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPowerSupplyRule());
            					}
            					set(
            						current,
            						"rating",
            						lv_rating_6_0,
            						"org.xtext.example.computer.ComputerDsl.Rating");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getPowerSupplyAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePowerSupply"


    // $ANTLR start "rulePeripheralKind"
    // InternalComputerDsl.g:1688:1: rulePeripheralKind returns [Enumerator current=null] : ( (enumLiteral_0= 'monitor' ) | (enumLiteral_1= 'keyboard' ) | (enumLiteral_2= 'mouse' ) | (enumLiteral_3= 'printer' ) ) ;
    public final Enumerator rulePeripheralKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalComputerDsl.g:1694:2: ( ( (enumLiteral_0= 'monitor' ) | (enumLiteral_1= 'keyboard' ) | (enumLiteral_2= 'mouse' ) | (enumLiteral_3= 'printer' ) ) )
            // InternalComputerDsl.g:1695:2: ( (enumLiteral_0= 'monitor' ) | (enumLiteral_1= 'keyboard' ) | (enumLiteral_2= 'mouse' ) | (enumLiteral_3= 'printer' ) )
            {
            // InternalComputerDsl.g:1695:2: ( (enumLiteral_0= 'monitor' ) | (enumLiteral_1= 'keyboard' ) | (enumLiteral_2= 'mouse' ) | (enumLiteral_3= 'printer' ) )
            int alt17=4;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt17=1;
                }
                break;
            case 39:
                {
                alt17=2;
                }
                break;
            case 40:
                {
                alt17=3;
                }
                break;
            case 41:
                {
                alt17=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalComputerDsl.g:1696:3: (enumLiteral_0= 'monitor' )
                    {
                    // InternalComputerDsl.g:1696:3: (enumLiteral_0= 'monitor' )
                    // InternalComputerDsl.g:1697:4: enumLiteral_0= 'monitor'
                    {
                    enumLiteral_0=(Token)match(input,38,FOLLOW_2); 

                    				current = grammarAccess.getPeripheralKindAccess().getMONITOREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPeripheralKindAccess().getMONITOREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:1704:3: (enumLiteral_1= 'keyboard' )
                    {
                    // InternalComputerDsl.g:1704:3: (enumLiteral_1= 'keyboard' )
                    // InternalComputerDsl.g:1705:4: enumLiteral_1= 'keyboard'
                    {
                    enumLiteral_1=(Token)match(input,39,FOLLOW_2); 

                    				current = grammarAccess.getPeripheralKindAccess().getKEYBOARDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPeripheralKindAccess().getKEYBOARDEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalComputerDsl.g:1712:3: (enumLiteral_2= 'mouse' )
                    {
                    // InternalComputerDsl.g:1712:3: (enumLiteral_2= 'mouse' )
                    // InternalComputerDsl.g:1713:4: enumLiteral_2= 'mouse'
                    {
                    enumLiteral_2=(Token)match(input,40,FOLLOW_2); 

                    				current = grammarAccess.getPeripheralKindAccess().getMOUSEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getPeripheralKindAccess().getMOUSEEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalComputerDsl.g:1720:3: (enumLiteral_3= 'printer' )
                    {
                    // InternalComputerDsl.g:1720:3: (enumLiteral_3= 'printer' )
                    // InternalComputerDsl.g:1721:4: enumLiteral_3= 'printer'
                    {
                    enumLiteral_3=(Token)match(input,41,FOLLOW_2); 

                    				current = grammarAccess.getPeripheralKindAccess().getPRINTEREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getPeripheralKindAccess().getPRINTEREnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePeripheralKind"


    // $ANTLR start "ruleMotherboardType"
    // InternalComputerDsl.g:1731:1: ruleMotherboardType returns [Enumerator current=null] : ( (enumLiteral_0= 'ATX' ) | (enumLiteral_1= 'MicroATX' ) | (enumLiteral_2= 'MiniITX' ) ) ;
    public final Enumerator ruleMotherboardType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalComputerDsl.g:1737:2: ( ( (enumLiteral_0= 'ATX' ) | (enumLiteral_1= 'MicroATX' ) | (enumLiteral_2= 'MiniITX' ) ) )
            // InternalComputerDsl.g:1738:2: ( (enumLiteral_0= 'ATX' ) | (enumLiteral_1= 'MicroATX' ) | (enumLiteral_2= 'MiniITX' ) )
            {
            // InternalComputerDsl.g:1738:2: ( (enumLiteral_0= 'ATX' ) | (enumLiteral_1= 'MicroATX' ) | (enumLiteral_2= 'MiniITX' ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt18=1;
                }
                break;
            case 43:
                {
                alt18=2;
                }
                break;
            case 44:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalComputerDsl.g:1739:3: (enumLiteral_0= 'ATX' )
                    {
                    // InternalComputerDsl.g:1739:3: (enumLiteral_0= 'ATX' )
                    // InternalComputerDsl.g:1740:4: enumLiteral_0= 'ATX'
                    {
                    enumLiteral_0=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getMotherboardTypeAccess().getATXEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMotherboardTypeAccess().getATXEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:1747:3: (enumLiteral_1= 'MicroATX' )
                    {
                    // InternalComputerDsl.g:1747:3: (enumLiteral_1= 'MicroATX' )
                    // InternalComputerDsl.g:1748:4: enumLiteral_1= 'MicroATX'
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getMotherboardTypeAccess().getMicroATXEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMotherboardTypeAccess().getMicroATXEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalComputerDsl.g:1755:3: (enumLiteral_2= 'MiniITX' )
                    {
                    // InternalComputerDsl.g:1755:3: (enumLiteral_2= 'MiniITX' )
                    // InternalComputerDsl.g:1756:4: enumLiteral_2= 'MiniITX'
                    {
                    enumLiteral_2=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getMotherboardTypeAccess().getMiniITXEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getMotherboardTypeAccess().getMiniITXEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMotherboardType"


    // $ANTLR start "ruleSocket"
    // InternalComputerDsl.g:1766:1: ruleSocket returns [Enumerator current=null] : ( (enumLiteral_0= 'AM4' ) | (enumLiteral_1= 'AM5' ) | (enumLiteral_2= 'LGA1200' ) | (enumLiteral_3= 'LGA1700' ) ) ;
    public final Enumerator ruleSocket() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalComputerDsl.g:1772:2: ( ( (enumLiteral_0= 'AM4' ) | (enumLiteral_1= 'AM5' ) | (enumLiteral_2= 'LGA1200' ) | (enumLiteral_3= 'LGA1700' ) ) )
            // InternalComputerDsl.g:1773:2: ( (enumLiteral_0= 'AM4' ) | (enumLiteral_1= 'AM5' ) | (enumLiteral_2= 'LGA1200' ) | (enumLiteral_3= 'LGA1700' ) )
            {
            // InternalComputerDsl.g:1773:2: ( (enumLiteral_0= 'AM4' ) | (enumLiteral_1= 'AM5' ) | (enumLiteral_2= 'LGA1200' ) | (enumLiteral_3= 'LGA1700' ) )
            int alt19=4;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt19=1;
                }
                break;
            case 46:
                {
                alt19=2;
                }
                break;
            case 47:
                {
                alt19=3;
                }
                break;
            case 48:
                {
                alt19=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalComputerDsl.g:1774:3: (enumLiteral_0= 'AM4' )
                    {
                    // InternalComputerDsl.g:1774:3: (enumLiteral_0= 'AM4' )
                    // InternalComputerDsl.g:1775:4: enumLiteral_0= 'AM4'
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getSocketAccess().getAM4EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSocketAccess().getAM4EnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:1782:3: (enumLiteral_1= 'AM5' )
                    {
                    // InternalComputerDsl.g:1782:3: (enumLiteral_1= 'AM5' )
                    // InternalComputerDsl.g:1783:4: enumLiteral_1= 'AM5'
                    {
                    enumLiteral_1=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getSocketAccess().getAM5EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSocketAccess().getAM5EnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalComputerDsl.g:1790:3: (enumLiteral_2= 'LGA1200' )
                    {
                    // InternalComputerDsl.g:1790:3: (enumLiteral_2= 'LGA1200' )
                    // InternalComputerDsl.g:1791:4: enumLiteral_2= 'LGA1200'
                    {
                    enumLiteral_2=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getSocketAccess().getLGA1200EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getSocketAccess().getLGA1200EnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalComputerDsl.g:1798:3: (enumLiteral_3= 'LGA1700' )
                    {
                    // InternalComputerDsl.g:1798:3: (enumLiteral_3= 'LGA1700' )
                    // InternalComputerDsl.g:1799:4: enumLiteral_3= 'LGA1700'
                    {
                    enumLiteral_3=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getSocketAccess().getLGA1700EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getSocketAccess().getLGA1700EnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSocket"


    // $ANTLR start "rulePort"
    // InternalComputerDsl.g:1809:1: rulePort returns [Enumerator current=null] : ( (enumLiteral_0= 'USB' ) | (enumLiteral_1= 'PS2' ) | (enumLiteral_2= 'HDMI' ) | (enumLiteral_3= 'DisplayPort' ) | (enumLiteral_4= 'VGA' ) | (enumLiteral_5= 'Ethernet' ) | (enumLiteral_6= 'Audio' ) ) ;
    public final Enumerator rulePort() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;


        	enterRule();

        try {
            // InternalComputerDsl.g:1815:2: ( ( (enumLiteral_0= 'USB' ) | (enumLiteral_1= 'PS2' ) | (enumLiteral_2= 'HDMI' ) | (enumLiteral_3= 'DisplayPort' ) | (enumLiteral_4= 'VGA' ) | (enumLiteral_5= 'Ethernet' ) | (enumLiteral_6= 'Audio' ) ) )
            // InternalComputerDsl.g:1816:2: ( (enumLiteral_0= 'USB' ) | (enumLiteral_1= 'PS2' ) | (enumLiteral_2= 'HDMI' ) | (enumLiteral_3= 'DisplayPort' ) | (enumLiteral_4= 'VGA' ) | (enumLiteral_5= 'Ethernet' ) | (enumLiteral_6= 'Audio' ) )
            {
            // InternalComputerDsl.g:1816:2: ( (enumLiteral_0= 'USB' ) | (enumLiteral_1= 'PS2' ) | (enumLiteral_2= 'HDMI' ) | (enumLiteral_3= 'DisplayPort' ) | (enumLiteral_4= 'VGA' ) | (enumLiteral_5= 'Ethernet' ) | (enumLiteral_6= 'Audio' ) )
            int alt20=7;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt20=1;
                }
                break;
            case 50:
                {
                alt20=2;
                }
                break;
            case 51:
                {
                alt20=3;
                }
                break;
            case 52:
                {
                alt20=4;
                }
                break;
            case 53:
                {
                alt20=5;
                }
                break;
            case 54:
                {
                alt20=6;
                }
                break;
            case 55:
                {
                alt20=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalComputerDsl.g:1817:3: (enumLiteral_0= 'USB' )
                    {
                    // InternalComputerDsl.g:1817:3: (enumLiteral_0= 'USB' )
                    // InternalComputerDsl.g:1818:4: enumLiteral_0= 'USB'
                    {
                    enumLiteral_0=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getPortAccess().getUSBEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPortAccess().getUSBEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:1825:3: (enumLiteral_1= 'PS2' )
                    {
                    // InternalComputerDsl.g:1825:3: (enumLiteral_1= 'PS2' )
                    // InternalComputerDsl.g:1826:4: enumLiteral_1= 'PS2'
                    {
                    enumLiteral_1=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getPortAccess().getPS2EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPortAccess().getPS2EnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalComputerDsl.g:1833:3: (enumLiteral_2= 'HDMI' )
                    {
                    // InternalComputerDsl.g:1833:3: (enumLiteral_2= 'HDMI' )
                    // InternalComputerDsl.g:1834:4: enumLiteral_2= 'HDMI'
                    {
                    enumLiteral_2=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getPortAccess().getHDMIEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getPortAccess().getHDMIEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalComputerDsl.g:1841:3: (enumLiteral_3= 'DisplayPort' )
                    {
                    // InternalComputerDsl.g:1841:3: (enumLiteral_3= 'DisplayPort' )
                    // InternalComputerDsl.g:1842:4: enumLiteral_3= 'DisplayPort'
                    {
                    enumLiteral_3=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getPortAccess().getDisplayPortEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getPortAccess().getDisplayPortEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalComputerDsl.g:1849:3: (enumLiteral_4= 'VGA' )
                    {
                    // InternalComputerDsl.g:1849:3: (enumLiteral_4= 'VGA' )
                    // InternalComputerDsl.g:1850:4: enumLiteral_4= 'VGA'
                    {
                    enumLiteral_4=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getPortAccess().getVGAEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getPortAccess().getVGAEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalComputerDsl.g:1857:3: (enumLiteral_5= 'Ethernet' )
                    {
                    // InternalComputerDsl.g:1857:3: (enumLiteral_5= 'Ethernet' )
                    // InternalComputerDsl.g:1858:4: enumLiteral_5= 'Ethernet'
                    {
                    enumLiteral_5=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getPortAccess().getEthernetEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getPortAccess().getEthernetEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalComputerDsl.g:1865:3: (enumLiteral_6= 'Audio' )
                    {
                    // InternalComputerDsl.g:1865:3: (enumLiteral_6= 'Audio' )
                    // InternalComputerDsl.g:1866:4: enumLiteral_6= 'Audio'
                    {
                    enumLiteral_6=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getPortAccess().getAudioEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getPortAccess().getAudioEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePort"


    // $ANTLR start "ruleMemoryType"
    // InternalComputerDsl.g:1876:1: ruleMemoryType returns [Enumerator current=null] : ( (enumLiteral_0= 'DDR4' ) | (enumLiteral_1= 'DDR5' ) ) ;
    public final Enumerator ruleMemoryType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalComputerDsl.g:1882:2: ( ( (enumLiteral_0= 'DDR4' ) | (enumLiteral_1= 'DDR5' ) ) )
            // InternalComputerDsl.g:1883:2: ( (enumLiteral_0= 'DDR4' ) | (enumLiteral_1= 'DDR5' ) )
            {
            // InternalComputerDsl.g:1883:2: ( (enumLiteral_0= 'DDR4' ) | (enumLiteral_1= 'DDR5' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==56) ) {
                alt21=1;
            }
            else if ( (LA21_0==57) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalComputerDsl.g:1884:3: (enumLiteral_0= 'DDR4' )
                    {
                    // InternalComputerDsl.g:1884:3: (enumLiteral_0= 'DDR4' )
                    // InternalComputerDsl.g:1885:4: enumLiteral_0= 'DDR4'
                    {
                    enumLiteral_0=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getMemoryTypeAccess().getDDR4EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMemoryTypeAccess().getDDR4EnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:1892:3: (enumLiteral_1= 'DDR5' )
                    {
                    // InternalComputerDsl.g:1892:3: (enumLiteral_1= 'DDR5' )
                    // InternalComputerDsl.g:1893:4: enumLiteral_1= 'DDR5'
                    {
                    enumLiteral_1=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getMemoryTypeAccess().getDDR5EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMemoryTypeAccess().getDDR5EnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMemoryType"


    // $ANTLR start "ruleStorageType"
    // InternalComputerDsl.g:1903:1: ruleStorageType returns [Enumerator current=null] : ( (enumLiteral_0= 'HDD' ) | (enumLiteral_1= 'SSD' ) ) ;
    public final Enumerator ruleStorageType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalComputerDsl.g:1909:2: ( ( (enumLiteral_0= 'HDD' ) | (enumLiteral_1= 'SSD' ) ) )
            // InternalComputerDsl.g:1910:2: ( (enumLiteral_0= 'HDD' ) | (enumLiteral_1= 'SSD' ) )
            {
            // InternalComputerDsl.g:1910:2: ( (enumLiteral_0= 'HDD' ) | (enumLiteral_1= 'SSD' ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==58) ) {
                alt22=1;
            }
            else if ( (LA22_0==59) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalComputerDsl.g:1911:3: (enumLiteral_0= 'HDD' )
                    {
                    // InternalComputerDsl.g:1911:3: (enumLiteral_0= 'HDD' )
                    // InternalComputerDsl.g:1912:4: enumLiteral_0= 'HDD'
                    {
                    enumLiteral_0=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getStorageTypeAccess().getHDDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getStorageTypeAccess().getHDDEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:1919:3: (enumLiteral_1= 'SSD' )
                    {
                    // InternalComputerDsl.g:1919:3: (enumLiteral_1= 'SSD' )
                    // InternalComputerDsl.g:1920:4: enumLiteral_1= 'SSD'
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getStorageTypeAccess().getSSDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getStorageTypeAccess().getSSDEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStorageType"


    // $ANTLR start "ruleDriveType"
    // InternalComputerDsl.g:1930:1: ruleDriveType returns [Enumerator current=null] : ( (enumLiteral_0= 'CD_ROM' ) | (enumLiteral_1= 'CD_R' ) | (enumLiteral_2= 'CD_RW' ) | (enumLiteral_3= 'DVD_ROM' ) | (enumLiteral_4= 'BluRay' ) ) ;
    public final Enumerator ruleDriveType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalComputerDsl.g:1936:2: ( ( (enumLiteral_0= 'CD_ROM' ) | (enumLiteral_1= 'CD_R' ) | (enumLiteral_2= 'CD_RW' ) | (enumLiteral_3= 'DVD_ROM' ) | (enumLiteral_4= 'BluRay' ) ) )
            // InternalComputerDsl.g:1937:2: ( (enumLiteral_0= 'CD_ROM' ) | (enumLiteral_1= 'CD_R' ) | (enumLiteral_2= 'CD_RW' ) | (enumLiteral_3= 'DVD_ROM' ) | (enumLiteral_4= 'BluRay' ) )
            {
            // InternalComputerDsl.g:1937:2: ( (enumLiteral_0= 'CD_ROM' ) | (enumLiteral_1= 'CD_R' ) | (enumLiteral_2= 'CD_RW' ) | (enumLiteral_3= 'DVD_ROM' ) | (enumLiteral_4= 'BluRay' ) )
            int alt23=5;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt23=1;
                }
                break;
            case 61:
                {
                alt23=2;
                }
                break;
            case 62:
                {
                alt23=3;
                }
                break;
            case 63:
                {
                alt23=4;
                }
                break;
            case 64:
                {
                alt23=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalComputerDsl.g:1938:3: (enumLiteral_0= 'CD_ROM' )
                    {
                    // InternalComputerDsl.g:1938:3: (enumLiteral_0= 'CD_ROM' )
                    // InternalComputerDsl.g:1939:4: enumLiteral_0= 'CD_ROM'
                    {
                    enumLiteral_0=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getDriveTypeAccess().getCD_ROMEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDriveTypeAccess().getCD_ROMEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:1946:3: (enumLiteral_1= 'CD_R' )
                    {
                    // InternalComputerDsl.g:1946:3: (enumLiteral_1= 'CD_R' )
                    // InternalComputerDsl.g:1947:4: enumLiteral_1= 'CD_R'
                    {
                    enumLiteral_1=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getDriveTypeAccess().getCD_REnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDriveTypeAccess().getCD_REnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalComputerDsl.g:1954:3: (enumLiteral_2= 'CD_RW' )
                    {
                    // InternalComputerDsl.g:1954:3: (enumLiteral_2= 'CD_RW' )
                    // InternalComputerDsl.g:1955:4: enumLiteral_2= 'CD_RW'
                    {
                    enumLiteral_2=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getDriveTypeAccess().getCD_RWEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDriveTypeAccess().getCD_RWEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalComputerDsl.g:1962:3: (enumLiteral_3= 'DVD_ROM' )
                    {
                    // InternalComputerDsl.g:1962:3: (enumLiteral_3= 'DVD_ROM' )
                    // InternalComputerDsl.g:1963:4: enumLiteral_3= 'DVD_ROM'
                    {
                    enumLiteral_3=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getDriveTypeAccess().getDVD_ROMEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDriveTypeAccess().getDVD_ROMEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalComputerDsl.g:1970:3: (enumLiteral_4= 'BluRay' )
                    {
                    // InternalComputerDsl.g:1970:3: (enumLiteral_4= 'BluRay' )
                    // InternalComputerDsl.g:1971:4: enumLiteral_4= 'BluRay'
                    {
                    enumLiteral_4=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getDriveTypeAccess().getBluRayEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getDriveTypeAccess().getBluRayEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDriveType"


    // $ANTLR start "ruleRating"
    // InternalComputerDsl.g:1981:1: ruleRating returns [Enumerator current=null] : ( (enumLiteral_0= 'Bronze' ) | (enumLiteral_1= 'Silver' ) | (enumLiteral_2= 'Gold' ) | (enumLiteral_3= 'Platinum' ) | (enumLiteral_4= 'Titanium' ) ) ;
    public final Enumerator ruleRating() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalComputerDsl.g:1987:2: ( ( (enumLiteral_0= 'Bronze' ) | (enumLiteral_1= 'Silver' ) | (enumLiteral_2= 'Gold' ) | (enumLiteral_3= 'Platinum' ) | (enumLiteral_4= 'Titanium' ) ) )
            // InternalComputerDsl.g:1988:2: ( (enumLiteral_0= 'Bronze' ) | (enumLiteral_1= 'Silver' ) | (enumLiteral_2= 'Gold' ) | (enumLiteral_3= 'Platinum' ) | (enumLiteral_4= 'Titanium' ) )
            {
            // InternalComputerDsl.g:1988:2: ( (enumLiteral_0= 'Bronze' ) | (enumLiteral_1= 'Silver' ) | (enumLiteral_2= 'Gold' ) | (enumLiteral_3= 'Platinum' ) | (enumLiteral_4= 'Titanium' ) )
            int alt24=5;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt24=1;
                }
                break;
            case 66:
                {
                alt24=2;
                }
                break;
            case 67:
                {
                alt24=3;
                }
                break;
            case 68:
                {
                alt24=4;
                }
                break;
            case 69:
                {
                alt24=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalComputerDsl.g:1989:3: (enumLiteral_0= 'Bronze' )
                    {
                    // InternalComputerDsl.g:1989:3: (enumLiteral_0= 'Bronze' )
                    // InternalComputerDsl.g:1990:4: enumLiteral_0= 'Bronze'
                    {
                    enumLiteral_0=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getRatingAccess().getBronzeEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getRatingAccess().getBronzeEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:1997:3: (enumLiteral_1= 'Silver' )
                    {
                    // InternalComputerDsl.g:1997:3: (enumLiteral_1= 'Silver' )
                    // InternalComputerDsl.g:1998:4: enumLiteral_1= 'Silver'
                    {
                    enumLiteral_1=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getRatingAccess().getSilverEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getRatingAccess().getSilverEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalComputerDsl.g:2005:3: (enumLiteral_2= 'Gold' )
                    {
                    // InternalComputerDsl.g:2005:3: (enumLiteral_2= 'Gold' )
                    // InternalComputerDsl.g:2006:4: enumLiteral_2= 'Gold'
                    {
                    enumLiteral_2=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getRatingAccess().getGoldEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getRatingAccess().getGoldEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalComputerDsl.g:2013:3: (enumLiteral_3= 'Platinum' )
                    {
                    // InternalComputerDsl.g:2013:3: (enumLiteral_3= 'Platinum' )
                    // InternalComputerDsl.g:2014:4: enumLiteral_3= 'Platinum'
                    {
                    enumLiteral_3=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getRatingAccess().getPlatinumEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getRatingAccess().getPlatinumEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalComputerDsl.g:2021:3: (enumLiteral_4= 'Titanium' )
                    {
                    // InternalComputerDsl.g:2021:3: (enumLiteral_4= 'Titanium' )
                    // InternalComputerDsl.g:2022:4: enumLiteral_4= 'Titanium'
                    {
                    enumLiteral_4=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getRatingAccess().getTitaniumEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getRatingAccess().getTitaniumEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRating"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000003C005BE4802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000003C005BE6800L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000007400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00001C0000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0001E00000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000080002000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00FE000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000402000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000500000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0300000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0C00000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0xF000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x000000000000003EL});

}