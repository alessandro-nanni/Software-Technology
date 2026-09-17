package org.xtext.example.computer.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.xtext.example.computer.services.ComputerDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalComputerDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'monitor'", "'keyboard'", "'mouse'", "'printer'", "'ATX'", "'MicroATX'", "'MiniITX'", "'AM4'", "'AM5'", "'LGA1200'", "'LGA1700'", "'USB'", "'PS2'", "'HDMI'", "'DisplayPort'", "'VGA'", "'Ethernet'", "'Audio'", "'DDR4'", "'DDR5'", "'HDD'", "'SSD'", "'CD_ROM'", "'CD_R'", "'CD_RW'", "'DVD_ROM'", "'BluRay'", "'Bronze'", "'Silver'", "'Gold'", "'Platinum'", "'Titanium'", "'package'", "'{'", "'}'", "'import'", "'.'", "'.*'", "'computer'", "'motherboard'", "'processor'", "'memory'", "'storage'", "'psu'", "'graphics'", "','", "'drive'", "'peripherals'", "'power'", "'type'", "'chipset'", "'socket'", "'ports'", "'cores'", "'model'", "'vram'", "'capacity'", "'port'", "'rating'"
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

    	public void setGrammarAccess(ComputerDslGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalComputerDsl.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalComputerDsl.g:54:1: ( ruleModel EOF )
            // InternalComputerDsl.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalComputerDsl.g:62:1: ruleModel : ( ( rule__Model__ElementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:66:2: ( ( ( rule__Model__ElementsAssignment )* ) )
            // InternalComputerDsl.g:67:2: ( ( rule__Model__ElementsAssignment )* )
            {
            // InternalComputerDsl.g:67:2: ( ( rule__Model__ElementsAssignment )* )
            // InternalComputerDsl.g:68:3: ( rule__Model__ElementsAssignment )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment()); 
            // InternalComputerDsl.g:69:3: ( rule__Model__ElementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=11 && LA1_0<=14)||LA1_0==43||LA1_0==46||(LA1_0>=49 && LA1_0<=55)||LA1_0==57) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalComputerDsl.g:69:4: rule__Model__ElementsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__ElementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getElementsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleAbstractElement"
    // InternalComputerDsl.g:78:1: entryRuleAbstractElement : ruleAbstractElement EOF ;
    public final void entryRuleAbstractElement() throws RecognitionException {
        try {
            // InternalComputerDsl.g:79:1: ( ruleAbstractElement EOF )
            // InternalComputerDsl.g:80:1: ruleAbstractElement EOF
            {
             before(grammarAccess.getAbstractElementRule()); 
            pushFollow(FOLLOW_1);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getAbstractElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractElement"


    // $ANTLR start "ruleAbstractElement"
    // InternalComputerDsl.g:87:1: ruleAbstractElement : ( ( rule__AbstractElement__Alternatives ) ) ;
    public final void ruleAbstractElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:91:2: ( ( ( rule__AbstractElement__Alternatives ) ) )
            // InternalComputerDsl.g:92:2: ( ( rule__AbstractElement__Alternatives ) )
            {
            // InternalComputerDsl.g:92:2: ( ( rule__AbstractElement__Alternatives ) )
            // InternalComputerDsl.g:93:3: ( rule__AbstractElement__Alternatives )
            {
             before(grammarAccess.getAbstractElementAccess().getAlternatives()); 
            // InternalComputerDsl.g:94:3: ( rule__AbstractElement__Alternatives )
            // InternalComputerDsl.g:94:4: rule__AbstractElement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AbstractElement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAbstractElementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractElement"


    // $ANTLR start "entryRulePackageDeclaration"
    // InternalComputerDsl.g:103:1: entryRulePackageDeclaration : rulePackageDeclaration EOF ;
    public final void entryRulePackageDeclaration() throws RecognitionException {
        try {
            // InternalComputerDsl.g:104:1: ( rulePackageDeclaration EOF )
            // InternalComputerDsl.g:105:1: rulePackageDeclaration EOF
            {
             before(grammarAccess.getPackageDeclarationRule()); 
            pushFollow(FOLLOW_1);
            rulePackageDeclaration();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePackageDeclaration"


    // $ANTLR start "rulePackageDeclaration"
    // InternalComputerDsl.g:112:1: rulePackageDeclaration : ( ( rule__PackageDeclaration__Group__0 ) ) ;
    public final void rulePackageDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:116:2: ( ( ( rule__PackageDeclaration__Group__0 ) ) )
            // InternalComputerDsl.g:117:2: ( ( rule__PackageDeclaration__Group__0 ) )
            {
            // InternalComputerDsl.g:117:2: ( ( rule__PackageDeclaration__Group__0 ) )
            // InternalComputerDsl.g:118:3: ( rule__PackageDeclaration__Group__0 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getGroup()); 
            // InternalComputerDsl.g:119:3: ( rule__PackageDeclaration__Group__0 )
            // InternalComputerDsl.g:119:4: rule__PackageDeclaration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPackageDeclarationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePackageDeclaration"


    // $ANTLR start "entryRuleImport"
    // InternalComputerDsl.g:128:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalComputerDsl.g:129:1: ( ruleImport EOF )
            // InternalComputerDsl.g:130:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalComputerDsl.g:137:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:141:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalComputerDsl.g:142:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalComputerDsl.g:142:2: ( ( rule__Import__Group__0 ) )
            // InternalComputerDsl.g:143:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalComputerDsl.g:144:3: ( rule__Import__Group__0 )
            // InternalComputerDsl.g:144:4: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalComputerDsl.g:153:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalComputerDsl.g:154:1: ( ruleQualifiedName EOF )
            // InternalComputerDsl.g:155:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalComputerDsl.g:162:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:166:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalComputerDsl.g:167:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalComputerDsl.g:167:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalComputerDsl.g:168:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalComputerDsl.g:169:3: ( rule__QualifiedName__Group__0 )
            // InternalComputerDsl.g:169:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // InternalComputerDsl.g:178:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // InternalComputerDsl.g:179:1: ( ruleQualifiedNameWithWildcard EOF )
            // InternalComputerDsl.g:180:1: ruleQualifiedNameWithWildcard EOF
            {
             before(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedNameWithWildcard();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildcardRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // InternalComputerDsl.g:187:1: ruleQualifiedNameWithWildcard : ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:191:2: ( ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) )
            // InternalComputerDsl.g:192:2: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            {
            // InternalComputerDsl.g:192:2: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            // InternalComputerDsl.g:193:3: ( rule__QualifiedNameWithWildcard__Group__0 )
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 
            // InternalComputerDsl.g:194:3: ( rule__QualifiedNameWithWildcard__Group__0 )
            // InternalComputerDsl.g:194:4: rule__QualifiedNameWithWildcard__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedNameWithWildcard__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleComputer"
    // InternalComputerDsl.g:203:1: entryRuleComputer : ruleComputer EOF ;
    public final void entryRuleComputer() throws RecognitionException {
        try {
            // InternalComputerDsl.g:204:1: ( ruleComputer EOF )
            // InternalComputerDsl.g:205:1: ruleComputer EOF
            {
             before(grammarAccess.getComputerRule()); 
            pushFollow(FOLLOW_1);
            ruleComputer();

            state._fsp--;

             after(grammarAccess.getComputerRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComputer"


    // $ANTLR start "ruleComputer"
    // InternalComputerDsl.g:212:1: ruleComputer : ( ( rule__Computer__Group__0 ) ) ;
    public final void ruleComputer() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:216:2: ( ( ( rule__Computer__Group__0 ) ) )
            // InternalComputerDsl.g:217:2: ( ( rule__Computer__Group__0 ) )
            {
            // InternalComputerDsl.g:217:2: ( ( rule__Computer__Group__0 ) )
            // InternalComputerDsl.g:218:3: ( rule__Computer__Group__0 )
            {
             before(grammarAccess.getComputerAccess().getGroup()); 
            // InternalComputerDsl.g:219:3: ( rule__Computer__Group__0 )
            // InternalComputerDsl.g:219:4: rule__Computer__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Computer__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComputerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComputer"


    // $ANTLR start "entryRulePart"
    // InternalComputerDsl.g:228:1: entryRulePart : rulePart EOF ;
    public final void entryRulePart() throws RecognitionException {
        try {
            // InternalComputerDsl.g:229:1: ( rulePart EOF )
            // InternalComputerDsl.g:230:1: rulePart EOF
            {
             before(grammarAccess.getPartRule()); 
            pushFollow(FOLLOW_1);
            rulePart();

            state._fsp--;

             after(grammarAccess.getPartRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePart"


    // $ANTLR start "rulePart"
    // InternalComputerDsl.g:237:1: rulePart : ( ( rule__Part__Alternatives ) ) ;
    public final void rulePart() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:241:2: ( ( ( rule__Part__Alternatives ) ) )
            // InternalComputerDsl.g:242:2: ( ( rule__Part__Alternatives ) )
            {
            // InternalComputerDsl.g:242:2: ( ( rule__Part__Alternatives ) )
            // InternalComputerDsl.g:243:3: ( rule__Part__Alternatives )
            {
             before(grammarAccess.getPartAccess().getAlternatives()); 
            // InternalComputerDsl.g:244:3: ( rule__Part__Alternatives )
            // InternalComputerDsl.g:244:4: rule__Part__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Part__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPartAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePart"


    // $ANTLR start "entryRuleMotherboard"
    // InternalComputerDsl.g:253:1: entryRuleMotherboard : ruleMotherboard EOF ;
    public final void entryRuleMotherboard() throws RecognitionException {
        try {
            // InternalComputerDsl.g:254:1: ( ruleMotherboard EOF )
            // InternalComputerDsl.g:255:1: ruleMotherboard EOF
            {
             before(grammarAccess.getMotherboardRule()); 
            pushFollow(FOLLOW_1);
            ruleMotherboard();

            state._fsp--;

             after(grammarAccess.getMotherboardRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMotherboard"


    // $ANTLR start "ruleMotherboard"
    // InternalComputerDsl.g:262:1: ruleMotherboard : ( ( rule__Motherboard__Group__0 ) ) ;
    public final void ruleMotherboard() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:266:2: ( ( ( rule__Motherboard__Group__0 ) ) )
            // InternalComputerDsl.g:267:2: ( ( rule__Motherboard__Group__0 ) )
            {
            // InternalComputerDsl.g:267:2: ( ( rule__Motherboard__Group__0 ) )
            // InternalComputerDsl.g:268:3: ( rule__Motherboard__Group__0 )
            {
             before(grammarAccess.getMotherboardAccess().getGroup()); 
            // InternalComputerDsl.g:269:3: ( rule__Motherboard__Group__0 )
            // InternalComputerDsl.g:269:4: rule__Motherboard__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Motherboard__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMotherboardAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMotherboard"


    // $ANTLR start "entryRuleProcessor"
    // InternalComputerDsl.g:278:1: entryRuleProcessor : ruleProcessor EOF ;
    public final void entryRuleProcessor() throws RecognitionException {
        try {
            // InternalComputerDsl.g:279:1: ( ruleProcessor EOF )
            // InternalComputerDsl.g:280:1: ruleProcessor EOF
            {
             before(grammarAccess.getProcessorRule()); 
            pushFollow(FOLLOW_1);
            ruleProcessor();

            state._fsp--;

             after(grammarAccess.getProcessorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProcessor"


    // $ANTLR start "ruleProcessor"
    // InternalComputerDsl.g:287:1: ruleProcessor : ( ( rule__Processor__Group__0 ) ) ;
    public final void ruleProcessor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:291:2: ( ( ( rule__Processor__Group__0 ) ) )
            // InternalComputerDsl.g:292:2: ( ( rule__Processor__Group__0 ) )
            {
            // InternalComputerDsl.g:292:2: ( ( rule__Processor__Group__0 ) )
            // InternalComputerDsl.g:293:3: ( rule__Processor__Group__0 )
            {
             before(grammarAccess.getProcessorAccess().getGroup()); 
            // InternalComputerDsl.g:294:3: ( rule__Processor__Group__0 )
            // InternalComputerDsl.g:294:4: rule__Processor__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Processor__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProcessorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProcessor"


    // $ANTLR start "entryRuleGraphicsCard"
    // InternalComputerDsl.g:303:1: entryRuleGraphicsCard : ruleGraphicsCard EOF ;
    public final void entryRuleGraphicsCard() throws RecognitionException {
        try {
            // InternalComputerDsl.g:304:1: ( ruleGraphicsCard EOF )
            // InternalComputerDsl.g:305:1: ruleGraphicsCard EOF
            {
             before(grammarAccess.getGraphicsCardRule()); 
            pushFollow(FOLLOW_1);
            ruleGraphicsCard();

            state._fsp--;

             after(grammarAccess.getGraphicsCardRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleGraphicsCard"


    // $ANTLR start "ruleGraphicsCard"
    // InternalComputerDsl.g:312:1: ruleGraphicsCard : ( ( rule__GraphicsCard__Group__0 ) ) ;
    public final void ruleGraphicsCard() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:316:2: ( ( ( rule__GraphicsCard__Group__0 ) ) )
            // InternalComputerDsl.g:317:2: ( ( rule__GraphicsCard__Group__0 ) )
            {
            // InternalComputerDsl.g:317:2: ( ( rule__GraphicsCard__Group__0 ) )
            // InternalComputerDsl.g:318:3: ( rule__GraphicsCard__Group__0 )
            {
             before(grammarAccess.getGraphicsCardAccess().getGroup()); 
            // InternalComputerDsl.g:319:3: ( rule__GraphicsCard__Group__0 )
            // InternalComputerDsl.g:319:4: rule__GraphicsCard__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__GraphicsCard__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getGraphicsCardAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGraphicsCard"


    // $ANTLR start "entryRuleMemory"
    // InternalComputerDsl.g:328:1: entryRuleMemory : ruleMemory EOF ;
    public final void entryRuleMemory() throws RecognitionException {
        try {
            // InternalComputerDsl.g:329:1: ( ruleMemory EOF )
            // InternalComputerDsl.g:330:1: ruleMemory EOF
            {
             before(grammarAccess.getMemoryRule()); 
            pushFollow(FOLLOW_1);
            ruleMemory();

            state._fsp--;

             after(grammarAccess.getMemoryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMemory"


    // $ANTLR start "ruleMemory"
    // InternalComputerDsl.g:337:1: ruleMemory : ( ( rule__Memory__Group__0 ) ) ;
    public final void ruleMemory() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:341:2: ( ( ( rule__Memory__Group__0 ) ) )
            // InternalComputerDsl.g:342:2: ( ( rule__Memory__Group__0 ) )
            {
            // InternalComputerDsl.g:342:2: ( ( rule__Memory__Group__0 ) )
            // InternalComputerDsl.g:343:3: ( rule__Memory__Group__0 )
            {
             before(grammarAccess.getMemoryAccess().getGroup()); 
            // InternalComputerDsl.g:344:3: ( rule__Memory__Group__0 )
            // InternalComputerDsl.g:344:4: rule__Memory__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Memory__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMemoryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMemory"


    // $ANTLR start "entryRuleStorage"
    // InternalComputerDsl.g:353:1: entryRuleStorage : ruleStorage EOF ;
    public final void entryRuleStorage() throws RecognitionException {
        try {
            // InternalComputerDsl.g:354:1: ( ruleStorage EOF )
            // InternalComputerDsl.g:355:1: ruleStorage EOF
            {
             before(grammarAccess.getStorageRule()); 
            pushFollow(FOLLOW_1);
            ruleStorage();

            state._fsp--;

             after(grammarAccess.getStorageRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStorage"


    // $ANTLR start "ruleStorage"
    // InternalComputerDsl.g:362:1: ruleStorage : ( ( rule__Storage__Group__0 ) ) ;
    public final void ruleStorage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:366:2: ( ( ( rule__Storage__Group__0 ) ) )
            // InternalComputerDsl.g:367:2: ( ( rule__Storage__Group__0 ) )
            {
            // InternalComputerDsl.g:367:2: ( ( rule__Storage__Group__0 ) )
            // InternalComputerDsl.g:368:3: ( rule__Storage__Group__0 )
            {
             before(grammarAccess.getStorageAccess().getGroup()); 
            // InternalComputerDsl.g:369:3: ( rule__Storage__Group__0 )
            // InternalComputerDsl.g:369:4: rule__Storage__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Storage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStorageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStorage"


    // $ANTLR start "entryRuleDrive"
    // InternalComputerDsl.g:378:1: entryRuleDrive : ruleDrive EOF ;
    public final void entryRuleDrive() throws RecognitionException {
        try {
            // InternalComputerDsl.g:379:1: ( ruleDrive EOF )
            // InternalComputerDsl.g:380:1: ruleDrive EOF
            {
             before(grammarAccess.getDriveRule()); 
            pushFollow(FOLLOW_1);
            ruleDrive();

            state._fsp--;

             after(grammarAccess.getDriveRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDrive"


    // $ANTLR start "ruleDrive"
    // InternalComputerDsl.g:387:1: ruleDrive : ( ( rule__Drive__Group__0 ) ) ;
    public final void ruleDrive() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:391:2: ( ( ( rule__Drive__Group__0 ) ) )
            // InternalComputerDsl.g:392:2: ( ( rule__Drive__Group__0 ) )
            {
            // InternalComputerDsl.g:392:2: ( ( rule__Drive__Group__0 ) )
            // InternalComputerDsl.g:393:3: ( rule__Drive__Group__0 )
            {
             before(grammarAccess.getDriveAccess().getGroup()); 
            // InternalComputerDsl.g:394:3: ( rule__Drive__Group__0 )
            // InternalComputerDsl.g:394:4: rule__Drive__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Drive__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDriveAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDrive"


    // $ANTLR start "entryRulePeripheral"
    // InternalComputerDsl.g:403:1: entryRulePeripheral : rulePeripheral EOF ;
    public final void entryRulePeripheral() throws RecognitionException {
        try {
            // InternalComputerDsl.g:404:1: ( rulePeripheral EOF )
            // InternalComputerDsl.g:405:1: rulePeripheral EOF
            {
             before(grammarAccess.getPeripheralRule()); 
            pushFollow(FOLLOW_1);
            rulePeripheral();

            state._fsp--;

             after(grammarAccess.getPeripheralRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePeripheral"


    // $ANTLR start "rulePeripheral"
    // InternalComputerDsl.g:412:1: rulePeripheral : ( ( rule__Peripheral__Group__0 ) ) ;
    public final void rulePeripheral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:416:2: ( ( ( rule__Peripheral__Group__0 ) ) )
            // InternalComputerDsl.g:417:2: ( ( rule__Peripheral__Group__0 ) )
            {
            // InternalComputerDsl.g:417:2: ( ( rule__Peripheral__Group__0 ) )
            // InternalComputerDsl.g:418:3: ( rule__Peripheral__Group__0 )
            {
             before(grammarAccess.getPeripheralAccess().getGroup()); 
            // InternalComputerDsl.g:419:3: ( rule__Peripheral__Group__0 )
            // InternalComputerDsl.g:419:4: rule__Peripheral__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Peripheral__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPeripheralAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePeripheral"


    // $ANTLR start "entryRulePowerSupply"
    // InternalComputerDsl.g:428:1: entryRulePowerSupply : rulePowerSupply EOF ;
    public final void entryRulePowerSupply() throws RecognitionException {
        try {
            // InternalComputerDsl.g:429:1: ( rulePowerSupply EOF )
            // InternalComputerDsl.g:430:1: rulePowerSupply EOF
            {
             before(grammarAccess.getPowerSupplyRule()); 
            pushFollow(FOLLOW_1);
            rulePowerSupply();

            state._fsp--;

             after(grammarAccess.getPowerSupplyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePowerSupply"


    // $ANTLR start "rulePowerSupply"
    // InternalComputerDsl.g:437:1: rulePowerSupply : ( ( rule__PowerSupply__Group__0 ) ) ;
    public final void rulePowerSupply() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:441:2: ( ( ( rule__PowerSupply__Group__0 ) ) )
            // InternalComputerDsl.g:442:2: ( ( rule__PowerSupply__Group__0 ) )
            {
            // InternalComputerDsl.g:442:2: ( ( rule__PowerSupply__Group__0 ) )
            // InternalComputerDsl.g:443:3: ( rule__PowerSupply__Group__0 )
            {
             before(grammarAccess.getPowerSupplyAccess().getGroup()); 
            // InternalComputerDsl.g:444:3: ( rule__PowerSupply__Group__0 )
            // InternalComputerDsl.g:444:4: rule__PowerSupply__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PowerSupply__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPowerSupplyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePowerSupply"


    // $ANTLR start "rulePeripheralKind"
    // InternalComputerDsl.g:453:1: rulePeripheralKind : ( ( rule__PeripheralKind__Alternatives ) ) ;
    public final void rulePeripheralKind() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:457:1: ( ( ( rule__PeripheralKind__Alternatives ) ) )
            // InternalComputerDsl.g:458:2: ( ( rule__PeripheralKind__Alternatives ) )
            {
            // InternalComputerDsl.g:458:2: ( ( rule__PeripheralKind__Alternatives ) )
            // InternalComputerDsl.g:459:3: ( rule__PeripheralKind__Alternatives )
            {
             before(grammarAccess.getPeripheralKindAccess().getAlternatives()); 
            // InternalComputerDsl.g:460:3: ( rule__PeripheralKind__Alternatives )
            // InternalComputerDsl.g:460:4: rule__PeripheralKind__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PeripheralKind__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPeripheralKindAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePeripheralKind"


    // $ANTLR start "ruleMotherboardType"
    // InternalComputerDsl.g:469:1: ruleMotherboardType : ( ( rule__MotherboardType__Alternatives ) ) ;
    public final void ruleMotherboardType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:473:1: ( ( ( rule__MotherboardType__Alternatives ) ) )
            // InternalComputerDsl.g:474:2: ( ( rule__MotherboardType__Alternatives ) )
            {
            // InternalComputerDsl.g:474:2: ( ( rule__MotherboardType__Alternatives ) )
            // InternalComputerDsl.g:475:3: ( rule__MotherboardType__Alternatives )
            {
             before(grammarAccess.getMotherboardTypeAccess().getAlternatives()); 
            // InternalComputerDsl.g:476:3: ( rule__MotherboardType__Alternatives )
            // InternalComputerDsl.g:476:4: rule__MotherboardType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__MotherboardType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMotherboardTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMotherboardType"


    // $ANTLR start "ruleSocket"
    // InternalComputerDsl.g:485:1: ruleSocket : ( ( rule__Socket__Alternatives ) ) ;
    public final void ruleSocket() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:489:1: ( ( ( rule__Socket__Alternatives ) ) )
            // InternalComputerDsl.g:490:2: ( ( rule__Socket__Alternatives ) )
            {
            // InternalComputerDsl.g:490:2: ( ( rule__Socket__Alternatives ) )
            // InternalComputerDsl.g:491:3: ( rule__Socket__Alternatives )
            {
             before(grammarAccess.getSocketAccess().getAlternatives()); 
            // InternalComputerDsl.g:492:3: ( rule__Socket__Alternatives )
            // InternalComputerDsl.g:492:4: rule__Socket__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Socket__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSocketAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSocket"


    // $ANTLR start "rulePort"
    // InternalComputerDsl.g:501:1: rulePort : ( ( rule__Port__Alternatives ) ) ;
    public final void rulePort() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:505:1: ( ( ( rule__Port__Alternatives ) ) )
            // InternalComputerDsl.g:506:2: ( ( rule__Port__Alternatives ) )
            {
            // InternalComputerDsl.g:506:2: ( ( rule__Port__Alternatives ) )
            // InternalComputerDsl.g:507:3: ( rule__Port__Alternatives )
            {
             before(grammarAccess.getPortAccess().getAlternatives()); 
            // InternalComputerDsl.g:508:3: ( rule__Port__Alternatives )
            // InternalComputerDsl.g:508:4: rule__Port__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Port__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPortAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePort"


    // $ANTLR start "ruleMemoryType"
    // InternalComputerDsl.g:517:1: ruleMemoryType : ( ( rule__MemoryType__Alternatives ) ) ;
    public final void ruleMemoryType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:521:1: ( ( ( rule__MemoryType__Alternatives ) ) )
            // InternalComputerDsl.g:522:2: ( ( rule__MemoryType__Alternatives ) )
            {
            // InternalComputerDsl.g:522:2: ( ( rule__MemoryType__Alternatives ) )
            // InternalComputerDsl.g:523:3: ( rule__MemoryType__Alternatives )
            {
             before(grammarAccess.getMemoryTypeAccess().getAlternatives()); 
            // InternalComputerDsl.g:524:3: ( rule__MemoryType__Alternatives )
            // InternalComputerDsl.g:524:4: rule__MemoryType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__MemoryType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMemoryTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMemoryType"


    // $ANTLR start "ruleStorageType"
    // InternalComputerDsl.g:533:1: ruleStorageType : ( ( rule__StorageType__Alternatives ) ) ;
    public final void ruleStorageType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:537:1: ( ( ( rule__StorageType__Alternatives ) ) )
            // InternalComputerDsl.g:538:2: ( ( rule__StorageType__Alternatives ) )
            {
            // InternalComputerDsl.g:538:2: ( ( rule__StorageType__Alternatives ) )
            // InternalComputerDsl.g:539:3: ( rule__StorageType__Alternatives )
            {
             before(grammarAccess.getStorageTypeAccess().getAlternatives()); 
            // InternalComputerDsl.g:540:3: ( rule__StorageType__Alternatives )
            // InternalComputerDsl.g:540:4: rule__StorageType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__StorageType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStorageTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStorageType"


    // $ANTLR start "ruleDriveType"
    // InternalComputerDsl.g:549:1: ruleDriveType : ( ( rule__DriveType__Alternatives ) ) ;
    public final void ruleDriveType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:553:1: ( ( ( rule__DriveType__Alternatives ) ) )
            // InternalComputerDsl.g:554:2: ( ( rule__DriveType__Alternatives ) )
            {
            // InternalComputerDsl.g:554:2: ( ( rule__DriveType__Alternatives ) )
            // InternalComputerDsl.g:555:3: ( rule__DriveType__Alternatives )
            {
             before(grammarAccess.getDriveTypeAccess().getAlternatives()); 
            // InternalComputerDsl.g:556:3: ( rule__DriveType__Alternatives )
            // InternalComputerDsl.g:556:4: rule__DriveType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__DriveType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDriveTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDriveType"


    // $ANTLR start "ruleRating"
    // InternalComputerDsl.g:565:1: ruleRating : ( ( rule__Rating__Alternatives ) ) ;
    public final void ruleRating() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:569:1: ( ( ( rule__Rating__Alternatives ) ) )
            // InternalComputerDsl.g:570:2: ( ( rule__Rating__Alternatives ) )
            {
            // InternalComputerDsl.g:570:2: ( ( rule__Rating__Alternatives ) )
            // InternalComputerDsl.g:571:3: ( rule__Rating__Alternatives )
            {
             before(grammarAccess.getRatingAccess().getAlternatives()); 
            // InternalComputerDsl.g:572:3: ( rule__Rating__Alternatives )
            // InternalComputerDsl.g:572:4: rule__Rating__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Rating__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRatingAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRating"


    // $ANTLR start "rule__AbstractElement__Alternatives"
    // InternalComputerDsl.g:580:1: rule__AbstractElement__Alternatives : ( ( rulePackageDeclaration ) | ( ruleImport ) | ( rulePart ) | ( ruleComputer ) );
    public final void rule__AbstractElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:584:1: ( ( rulePackageDeclaration ) | ( ruleImport ) | ( rulePart ) | ( ruleComputer ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt2=1;
                }
                break;
            case 46:
                {
                alt2=2;
                }
                break;
            case 11:
            case 12:
            case 13:
            case 14:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 57:
                {
                alt2=3;
                }
                break;
            case 49:
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
                    // InternalComputerDsl.g:585:2: ( rulePackageDeclaration )
                    {
                    // InternalComputerDsl.g:585:2: ( rulePackageDeclaration )
                    // InternalComputerDsl.g:586:3: rulePackageDeclaration
                    {
                     before(grammarAccess.getAbstractElementAccess().getPackageDeclarationParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePackageDeclaration();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getPackageDeclarationParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:591:2: ( ruleImport )
                    {
                    // InternalComputerDsl.g:591:2: ( ruleImport )
                    // InternalComputerDsl.g:592:3: ruleImport
                    {
                     before(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getImportParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalComputerDsl.g:597:2: ( rulePart )
                    {
                    // InternalComputerDsl.g:597:2: ( rulePart )
                    // InternalComputerDsl.g:598:3: rulePart
                    {
                     before(grammarAccess.getAbstractElementAccess().getPartParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    rulePart();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getPartParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalComputerDsl.g:603:2: ( ruleComputer )
                    {
                    // InternalComputerDsl.g:603:2: ( ruleComputer )
                    // InternalComputerDsl.g:604:3: ruleComputer
                    {
                     before(grammarAccess.getAbstractElementAccess().getComputerParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleComputer();

                    state._fsp--;

                     after(grammarAccess.getAbstractElementAccess().getComputerParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractElement__Alternatives"


    // $ANTLR start "rule__Part__Alternatives"
    // InternalComputerDsl.g:613:1: rule__Part__Alternatives : ( ( ruleMotherboard ) | ( ruleProcessor ) | ( ruleGraphicsCard ) | ( ruleMemory ) | ( ruleStorage ) | ( ruleDrive ) | ( rulePeripheral ) | ( rulePowerSupply ) );
    public final void rule__Part__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:617:1: ( ( ruleMotherboard ) | ( ruleProcessor ) | ( ruleGraphicsCard ) | ( ruleMemory ) | ( ruleStorage ) | ( ruleDrive ) | ( rulePeripheral ) | ( rulePowerSupply ) )
            int alt3=8;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt3=1;
                }
                break;
            case 51:
                {
                alt3=2;
                }
                break;
            case 55:
                {
                alt3=3;
                }
                break;
            case 52:
                {
                alt3=4;
                }
                break;
            case 53:
                {
                alt3=5;
                }
                break;
            case 57:
                {
                alt3=6;
                }
                break;
            case 11:
            case 12:
            case 13:
            case 14:
                {
                alt3=7;
                }
                break;
            case 54:
                {
                alt3=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalComputerDsl.g:618:2: ( ruleMotherboard )
                    {
                    // InternalComputerDsl.g:618:2: ( ruleMotherboard )
                    // InternalComputerDsl.g:619:3: ruleMotherboard
                    {
                     before(grammarAccess.getPartAccess().getMotherboardParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleMotherboard();

                    state._fsp--;

                     after(grammarAccess.getPartAccess().getMotherboardParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:624:2: ( ruleProcessor )
                    {
                    // InternalComputerDsl.g:624:2: ( ruleProcessor )
                    // InternalComputerDsl.g:625:3: ruleProcessor
                    {
                     before(grammarAccess.getPartAccess().getProcessorParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleProcessor();

                    state._fsp--;

                     after(grammarAccess.getPartAccess().getProcessorParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalComputerDsl.g:630:2: ( ruleGraphicsCard )
                    {
                    // InternalComputerDsl.g:630:2: ( ruleGraphicsCard )
                    // InternalComputerDsl.g:631:3: ruleGraphicsCard
                    {
                     before(grammarAccess.getPartAccess().getGraphicsCardParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleGraphicsCard();

                    state._fsp--;

                     after(grammarAccess.getPartAccess().getGraphicsCardParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalComputerDsl.g:636:2: ( ruleMemory )
                    {
                    // InternalComputerDsl.g:636:2: ( ruleMemory )
                    // InternalComputerDsl.g:637:3: ruleMemory
                    {
                     before(grammarAccess.getPartAccess().getMemoryParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleMemory();

                    state._fsp--;

                     after(grammarAccess.getPartAccess().getMemoryParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalComputerDsl.g:642:2: ( ruleStorage )
                    {
                    // InternalComputerDsl.g:642:2: ( ruleStorage )
                    // InternalComputerDsl.g:643:3: ruleStorage
                    {
                     before(grammarAccess.getPartAccess().getStorageParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleStorage();

                    state._fsp--;

                     after(grammarAccess.getPartAccess().getStorageParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalComputerDsl.g:648:2: ( ruleDrive )
                    {
                    // InternalComputerDsl.g:648:2: ( ruleDrive )
                    // InternalComputerDsl.g:649:3: ruleDrive
                    {
                     before(grammarAccess.getPartAccess().getDriveParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleDrive();

                    state._fsp--;

                     after(grammarAccess.getPartAccess().getDriveParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalComputerDsl.g:654:2: ( rulePeripheral )
                    {
                    // InternalComputerDsl.g:654:2: ( rulePeripheral )
                    // InternalComputerDsl.g:655:3: rulePeripheral
                    {
                     before(grammarAccess.getPartAccess().getPeripheralParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    rulePeripheral();

                    state._fsp--;

                     after(grammarAccess.getPartAccess().getPeripheralParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalComputerDsl.g:660:2: ( rulePowerSupply )
                    {
                    // InternalComputerDsl.g:660:2: ( rulePowerSupply )
                    // InternalComputerDsl.g:661:3: rulePowerSupply
                    {
                     before(grammarAccess.getPartAccess().getPowerSupplyParserRuleCall_7()); 
                    pushFollow(FOLLOW_2);
                    rulePowerSupply();

                    state._fsp--;

                     after(grammarAccess.getPartAccess().getPowerSupplyParserRuleCall_7()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Part__Alternatives"


    // $ANTLR start "rule__PeripheralKind__Alternatives"
    // InternalComputerDsl.g:670:1: rule__PeripheralKind__Alternatives : ( ( ( 'monitor' ) ) | ( ( 'keyboard' ) ) | ( ( 'mouse' ) ) | ( ( 'printer' ) ) );
    public final void rule__PeripheralKind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:674:1: ( ( ( 'monitor' ) ) | ( ( 'keyboard' ) ) | ( ( 'mouse' ) ) | ( ( 'printer' ) ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt4=1;
                }
                break;
            case 12:
                {
                alt4=2;
                }
                break;
            case 13:
                {
                alt4=3;
                }
                break;
            case 14:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalComputerDsl.g:675:2: ( ( 'monitor' ) )
                    {
                    // InternalComputerDsl.g:675:2: ( ( 'monitor' ) )
                    // InternalComputerDsl.g:676:3: ( 'monitor' )
                    {
                     before(grammarAccess.getPeripheralKindAccess().getMONITOREnumLiteralDeclaration_0()); 
                    // InternalComputerDsl.g:677:3: ( 'monitor' )
                    // InternalComputerDsl.g:677:4: 'monitor'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getPeripheralKindAccess().getMONITOREnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:681:2: ( ( 'keyboard' ) )
                    {
                    // InternalComputerDsl.g:681:2: ( ( 'keyboard' ) )
                    // InternalComputerDsl.g:682:3: ( 'keyboard' )
                    {
                     before(grammarAccess.getPeripheralKindAccess().getKEYBOARDEnumLiteralDeclaration_1()); 
                    // InternalComputerDsl.g:683:3: ( 'keyboard' )
                    // InternalComputerDsl.g:683:4: 'keyboard'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getPeripheralKindAccess().getKEYBOARDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalComputerDsl.g:687:2: ( ( 'mouse' ) )
                    {
                    // InternalComputerDsl.g:687:2: ( ( 'mouse' ) )
                    // InternalComputerDsl.g:688:3: ( 'mouse' )
                    {
                     before(grammarAccess.getPeripheralKindAccess().getMOUSEEnumLiteralDeclaration_2()); 
                    // InternalComputerDsl.g:689:3: ( 'mouse' )
                    // InternalComputerDsl.g:689:4: 'mouse'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getPeripheralKindAccess().getMOUSEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalComputerDsl.g:693:2: ( ( 'printer' ) )
                    {
                    // InternalComputerDsl.g:693:2: ( ( 'printer' ) )
                    // InternalComputerDsl.g:694:3: ( 'printer' )
                    {
                     before(grammarAccess.getPeripheralKindAccess().getPRINTEREnumLiteralDeclaration_3()); 
                    // InternalComputerDsl.g:695:3: ( 'printer' )
                    // InternalComputerDsl.g:695:4: 'printer'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getPeripheralKindAccess().getPRINTEREnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PeripheralKind__Alternatives"


    // $ANTLR start "rule__MotherboardType__Alternatives"
    // InternalComputerDsl.g:703:1: rule__MotherboardType__Alternatives : ( ( ( 'ATX' ) ) | ( ( 'MicroATX' ) ) | ( ( 'MiniITX' ) ) );
    public final void rule__MotherboardType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:707:1: ( ( ( 'ATX' ) ) | ( ( 'MicroATX' ) ) | ( ( 'MiniITX' ) ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt5=1;
                }
                break;
            case 16:
                {
                alt5=2;
                }
                break;
            case 17:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalComputerDsl.g:708:2: ( ( 'ATX' ) )
                    {
                    // InternalComputerDsl.g:708:2: ( ( 'ATX' ) )
                    // InternalComputerDsl.g:709:3: ( 'ATX' )
                    {
                     before(grammarAccess.getMotherboardTypeAccess().getATXEnumLiteralDeclaration_0()); 
                    // InternalComputerDsl.g:710:3: ( 'ATX' )
                    // InternalComputerDsl.g:710:4: 'ATX'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getMotherboardTypeAccess().getATXEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:714:2: ( ( 'MicroATX' ) )
                    {
                    // InternalComputerDsl.g:714:2: ( ( 'MicroATX' ) )
                    // InternalComputerDsl.g:715:3: ( 'MicroATX' )
                    {
                     before(grammarAccess.getMotherboardTypeAccess().getMicroATXEnumLiteralDeclaration_1()); 
                    // InternalComputerDsl.g:716:3: ( 'MicroATX' )
                    // InternalComputerDsl.g:716:4: 'MicroATX'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getMotherboardTypeAccess().getMicroATXEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalComputerDsl.g:720:2: ( ( 'MiniITX' ) )
                    {
                    // InternalComputerDsl.g:720:2: ( ( 'MiniITX' ) )
                    // InternalComputerDsl.g:721:3: ( 'MiniITX' )
                    {
                     before(grammarAccess.getMotherboardTypeAccess().getMiniITXEnumLiteralDeclaration_2()); 
                    // InternalComputerDsl.g:722:3: ( 'MiniITX' )
                    // InternalComputerDsl.g:722:4: 'MiniITX'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getMotherboardTypeAccess().getMiniITXEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MotherboardType__Alternatives"


    // $ANTLR start "rule__Socket__Alternatives"
    // InternalComputerDsl.g:730:1: rule__Socket__Alternatives : ( ( ( 'AM4' ) ) | ( ( 'AM5' ) ) | ( ( 'LGA1200' ) ) | ( ( 'LGA1700' ) ) );
    public final void rule__Socket__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:734:1: ( ( ( 'AM4' ) ) | ( ( 'AM5' ) ) | ( ( 'LGA1200' ) ) | ( ( 'LGA1700' ) ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt6=1;
                }
                break;
            case 19:
                {
                alt6=2;
                }
                break;
            case 20:
                {
                alt6=3;
                }
                break;
            case 21:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalComputerDsl.g:735:2: ( ( 'AM4' ) )
                    {
                    // InternalComputerDsl.g:735:2: ( ( 'AM4' ) )
                    // InternalComputerDsl.g:736:3: ( 'AM4' )
                    {
                     before(grammarAccess.getSocketAccess().getAM4EnumLiteralDeclaration_0()); 
                    // InternalComputerDsl.g:737:3: ( 'AM4' )
                    // InternalComputerDsl.g:737:4: 'AM4'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getSocketAccess().getAM4EnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:741:2: ( ( 'AM5' ) )
                    {
                    // InternalComputerDsl.g:741:2: ( ( 'AM5' ) )
                    // InternalComputerDsl.g:742:3: ( 'AM5' )
                    {
                     before(grammarAccess.getSocketAccess().getAM5EnumLiteralDeclaration_1()); 
                    // InternalComputerDsl.g:743:3: ( 'AM5' )
                    // InternalComputerDsl.g:743:4: 'AM5'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getSocketAccess().getAM5EnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalComputerDsl.g:747:2: ( ( 'LGA1200' ) )
                    {
                    // InternalComputerDsl.g:747:2: ( ( 'LGA1200' ) )
                    // InternalComputerDsl.g:748:3: ( 'LGA1200' )
                    {
                     before(grammarAccess.getSocketAccess().getLGA1200EnumLiteralDeclaration_2()); 
                    // InternalComputerDsl.g:749:3: ( 'LGA1200' )
                    // InternalComputerDsl.g:749:4: 'LGA1200'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getSocketAccess().getLGA1200EnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalComputerDsl.g:753:2: ( ( 'LGA1700' ) )
                    {
                    // InternalComputerDsl.g:753:2: ( ( 'LGA1700' ) )
                    // InternalComputerDsl.g:754:3: ( 'LGA1700' )
                    {
                     before(grammarAccess.getSocketAccess().getLGA1700EnumLiteralDeclaration_3()); 
                    // InternalComputerDsl.g:755:3: ( 'LGA1700' )
                    // InternalComputerDsl.g:755:4: 'LGA1700'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getSocketAccess().getLGA1700EnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Socket__Alternatives"


    // $ANTLR start "rule__Port__Alternatives"
    // InternalComputerDsl.g:763:1: rule__Port__Alternatives : ( ( ( 'USB' ) ) | ( ( 'PS2' ) ) | ( ( 'HDMI' ) ) | ( ( 'DisplayPort' ) ) | ( ( 'VGA' ) ) | ( ( 'Ethernet' ) ) | ( ( 'Audio' ) ) );
    public final void rule__Port__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:767:1: ( ( ( 'USB' ) ) | ( ( 'PS2' ) ) | ( ( 'HDMI' ) ) | ( ( 'DisplayPort' ) ) | ( ( 'VGA' ) ) | ( ( 'Ethernet' ) ) | ( ( 'Audio' ) ) )
            int alt7=7;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt7=1;
                }
                break;
            case 23:
                {
                alt7=2;
                }
                break;
            case 24:
                {
                alt7=3;
                }
                break;
            case 25:
                {
                alt7=4;
                }
                break;
            case 26:
                {
                alt7=5;
                }
                break;
            case 27:
                {
                alt7=6;
                }
                break;
            case 28:
                {
                alt7=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalComputerDsl.g:768:2: ( ( 'USB' ) )
                    {
                    // InternalComputerDsl.g:768:2: ( ( 'USB' ) )
                    // InternalComputerDsl.g:769:3: ( 'USB' )
                    {
                     before(grammarAccess.getPortAccess().getUSBEnumLiteralDeclaration_0()); 
                    // InternalComputerDsl.g:770:3: ( 'USB' )
                    // InternalComputerDsl.g:770:4: 'USB'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getPortAccess().getUSBEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:774:2: ( ( 'PS2' ) )
                    {
                    // InternalComputerDsl.g:774:2: ( ( 'PS2' ) )
                    // InternalComputerDsl.g:775:3: ( 'PS2' )
                    {
                     before(grammarAccess.getPortAccess().getPS2EnumLiteralDeclaration_1()); 
                    // InternalComputerDsl.g:776:3: ( 'PS2' )
                    // InternalComputerDsl.g:776:4: 'PS2'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getPortAccess().getPS2EnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalComputerDsl.g:780:2: ( ( 'HDMI' ) )
                    {
                    // InternalComputerDsl.g:780:2: ( ( 'HDMI' ) )
                    // InternalComputerDsl.g:781:3: ( 'HDMI' )
                    {
                     before(grammarAccess.getPortAccess().getHDMIEnumLiteralDeclaration_2()); 
                    // InternalComputerDsl.g:782:3: ( 'HDMI' )
                    // InternalComputerDsl.g:782:4: 'HDMI'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getPortAccess().getHDMIEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalComputerDsl.g:786:2: ( ( 'DisplayPort' ) )
                    {
                    // InternalComputerDsl.g:786:2: ( ( 'DisplayPort' ) )
                    // InternalComputerDsl.g:787:3: ( 'DisplayPort' )
                    {
                     before(grammarAccess.getPortAccess().getDisplayPortEnumLiteralDeclaration_3()); 
                    // InternalComputerDsl.g:788:3: ( 'DisplayPort' )
                    // InternalComputerDsl.g:788:4: 'DisplayPort'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getPortAccess().getDisplayPortEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalComputerDsl.g:792:2: ( ( 'VGA' ) )
                    {
                    // InternalComputerDsl.g:792:2: ( ( 'VGA' ) )
                    // InternalComputerDsl.g:793:3: ( 'VGA' )
                    {
                     before(grammarAccess.getPortAccess().getVGAEnumLiteralDeclaration_4()); 
                    // InternalComputerDsl.g:794:3: ( 'VGA' )
                    // InternalComputerDsl.g:794:4: 'VGA'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getPortAccess().getVGAEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalComputerDsl.g:798:2: ( ( 'Ethernet' ) )
                    {
                    // InternalComputerDsl.g:798:2: ( ( 'Ethernet' ) )
                    // InternalComputerDsl.g:799:3: ( 'Ethernet' )
                    {
                     before(grammarAccess.getPortAccess().getEthernetEnumLiteralDeclaration_5()); 
                    // InternalComputerDsl.g:800:3: ( 'Ethernet' )
                    // InternalComputerDsl.g:800:4: 'Ethernet'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getPortAccess().getEthernetEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalComputerDsl.g:804:2: ( ( 'Audio' ) )
                    {
                    // InternalComputerDsl.g:804:2: ( ( 'Audio' ) )
                    // InternalComputerDsl.g:805:3: ( 'Audio' )
                    {
                     before(grammarAccess.getPortAccess().getAudioEnumLiteralDeclaration_6()); 
                    // InternalComputerDsl.g:806:3: ( 'Audio' )
                    // InternalComputerDsl.g:806:4: 'Audio'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getPortAccess().getAudioEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Port__Alternatives"


    // $ANTLR start "rule__MemoryType__Alternatives"
    // InternalComputerDsl.g:814:1: rule__MemoryType__Alternatives : ( ( ( 'DDR4' ) ) | ( ( 'DDR5' ) ) );
    public final void rule__MemoryType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:818:1: ( ( ( 'DDR4' ) ) | ( ( 'DDR5' ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                alt8=1;
            }
            else if ( (LA8_0==30) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalComputerDsl.g:819:2: ( ( 'DDR4' ) )
                    {
                    // InternalComputerDsl.g:819:2: ( ( 'DDR4' ) )
                    // InternalComputerDsl.g:820:3: ( 'DDR4' )
                    {
                     before(grammarAccess.getMemoryTypeAccess().getDDR4EnumLiteralDeclaration_0()); 
                    // InternalComputerDsl.g:821:3: ( 'DDR4' )
                    // InternalComputerDsl.g:821:4: 'DDR4'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getMemoryTypeAccess().getDDR4EnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:825:2: ( ( 'DDR5' ) )
                    {
                    // InternalComputerDsl.g:825:2: ( ( 'DDR5' ) )
                    // InternalComputerDsl.g:826:3: ( 'DDR5' )
                    {
                     before(grammarAccess.getMemoryTypeAccess().getDDR5EnumLiteralDeclaration_1()); 
                    // InternalComputerDsl.g:827:3: ( 'DDR5' )
                    // InternalComputerDsl.g:827:4: 'DDR5'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getMemoryTypeAccess().getDDR5EnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MemoryType__Alternatives"


    // $ANTLR start "rule__StorageType__Alternatives"
    // InternalComputerDsl.g:835:1: rule__StorageType__Alternatives : ( ( ( 'HDD' ) ) | ( ( 'SSD' ) ) );
    public final void rule__StorageType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:839:1: ( ( ( 'HDD' ) ) | ( ( 'SSD' ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==31) ) {
                alt9=1;
            }
            else if ( (LA9_0==32) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalComputerDsl.g:840:2: ( ( 'HDD' ) )
                    {
                    // InternalComputerDsl.g:840:2: ( ( 'HDD' ) )
                    // InternalComputerDsl.g:841:3: ( 'HDD' )
                    {
                     before(grammarAccess.getStorageTypeAccess().getHDDEnumLiteralDeclaration_0()); 
                    // InternalComputerDsl.g:842:3: ( 'HDD' )
                    // InternalComputerDsl.g:842:4: 'HDD'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getStorageTypeAccess().getHDDEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:846:2: ( ( 'SSD' ) )
                    {
                    // InternalComputerDsl.g:846:2: ( ( 'SSD' ) )
                    // InternalComputerDsl.g:847:3: ( 'SSD' )
                    {
                     before(grammarAccess.getStorageTypeAccess().getSSDEnumLiteralDeclaration_1()); 
                    // InternalComputerDsl.g:848:3: ( 'SSD' )
                    // InternalComputerDsl.g:848:4: 'SSD'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getStorageTypeAccess().getSSDEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StorageType__Alternatives"


    // $ANTLR start "rule__DriveType__Alternatives"
    // InternalComputerDsl.g:856:1: rule__DriveType__Alternatives : ( ( ( 'CD_ROM' ) ) | ( ( 'CD_R' ) ) | ( ( 'CD_RW' ) ) | ( ( 'DVD_ROM' ) ) | ( ( 'BluRay' ) ) );
    public final void rule__DriveType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:860:1: ( ( ( 'CD_ROM' ) ) | ( ( 'CD_R' ) ) | ( ( 'CD_RW' ) ) | ( ( 'DVD_ROM' ) ) | ( ( 'BluRay' ) ) )
            int alt10=5;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt10=1;
                }
                break;
            case 34:
                {
                alt10=2;
                }
                break;
            case 35:
                {
                alt10=3;
                }
                break;
            case 36:
                {
                alt10=4;
                }
                break;
            case 37:
                {
                alt10=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalComputerDsl.g:861:2: ( ( 'CD_ROM' ) )
                    {
                    // InternalComputerDsl.g:861:2: ( ( 'CD_ROM' ) )
                    // InternalComputerDsl.g:862:3: ( 'CD_ROM' )
                    {
                     before(grammarAccess.getDriveTypeAccess().getCD_ROMEnumLiteralDeclaration_0()); 
                    // InternalComputerDsl.g:863:3: ( 'CD_ROM' )
                    // InternalComputerDsl.g:863:4: 'CD_ROM'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getDriveTypeAccess().getCD_ROMEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:867:2: ( ( 'CD_R' ) )
                    {
                    // InternalComputerDsl.g:867:2: ( ( 'CD_R' ) )
                    // InternalComputerDsl.g:868:3: ( 'CD_R' )
                    {
                     before(grammarAccess.getDriveTypeAccess().getCD_REnumLiteralDeclaration_1()); 
                    // InternalComputerDsl.g:869:3: ( 'CD_R' )
                    // InternalComputerDsl.g:869:4: 'CD_R'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getDriveTypeAccess().getCD_REnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalComputerDsl.g:873:2: ( ( 'CD_RW' ) )
                    {
                    // InternalComputerDsl.g:873:2: ( ( 'CD_RW' ) )
                    // InternalComputerDsl.g:874:3: ( 'CD_RW' )
                    {
                     before(grammarAccess.getDriveTypeAccess().getCD_RWEnumLiteralDeclaration_2()); 
                    // InternalComputerDsl.g:875:3: ( 'CD_RW' )
                    // InternalComputerDsl.g:875:4: 'CD_RW'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getDriveTypeAccess().getCD_RWEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalComputerDsl.g:879:2: ( ( 'DVD_ROM' ) )
                    {
                    // InternalComputerDsl.g:879:2: ( ( 'DVD_ROM' ) )
                    // InternalComputerDsl.g:880:3: ( 'DVD_ROM' )
                    {
                     before(grammarAccess.getDriveTypeAccess().getDVD_ROMEnumLiteralDeclaration_3()); 
                    // InternalComputerDsl.g:881:3: ( 'DVD_ROM' )
                    // InternalComputerDsl.g:881:4: 'DVD_ROM'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getDriveTypeAccess().getDVD_ROMEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalComputerDsl.g:885:2: ( ( 'BluRay' ) )
                    {
                    // InternalComputerDsl.g:885:2: ( ( 'BluRay' ) )
                    // InternalComputerDsl.g:886:3: ( 'BluRay' )
                    {
                     before(grammarAccess.getDriveTypeAccess().getBluRayEnumLiteralDeclaration_4()); 
                    // InternalComputerDsl.g:887:3: ( 'BluRay' )
                    // InternalComputerDsl.g:887:4: 'BluRay'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getDriveTypeAccess().getBluRayEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DriveType__Alternatives"


    // $ANTLR start "rule__Rating__Alternatives"
    // InternalComputerDsl.g:895:1: rule__Rating__Alternatives : ( ( ( 'Bronze' ) ) | ( ( 'Silver' ) ) | ( ( 'Gold' ) ) | ( ( 'Platinum' ) ) | ( ( 'Titanium' ) ) );
    public final void rule__Rating__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:899:1: ( ( ( 'Bronze' ) ) | ( ( 'Silver' ) ) | ( ( 'Gold' ) ) | ( ( 'Platinum' ) ) | ( ( 'Titanium' ) ) )
            int alt11=5;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt11=1;
                }
                break;
            case 39:
                {
                alt11=2;
                }
                break;
            case 40:
                {
                alt11=3;
                }
                break;
            case 41:
                {
                alt11=4;
                }
                break;
            case 42:
                {
                alt11=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalComputerDsl.g:900:2: ( ( 'Bronze' ) )
                    {
                    // InternalComputerDsl.g:900:2: ( ( 'Bronze' ) )
                    // InternalComputerDsl.g:901:3: ( 'Bronze' )
                    {
                     before(grammarAccess.getRatingAccess().getBronzeEnumLiteralDeclaration_0()); 
                    // InternalComputerDsl.g:902:3: ( 'Bronze' )
                    // InternalComputerDsl.g:902:4: 'Bronze'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getRatingAccess().getBronzeEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalComputerDsl.g:906:2: ( ( 'Silver' ) )
                    {
                    // InternalComputerDsl.g:906:2: ( ( 'Silver' ) )
                    // InternalComputerDsl.g:907:3: ( 'Silver' )
                    {
                     before(grammarAccess.getRatingAccess().getSilverEnumLiteralDeclaration_1()); 
                    // InternalComputerDsl.g:908:3: ( 'Silver' )
                    // InternalComputerDsl.g:908:4: 'Silver'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getRatingAccess().getSilverEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalComputerDsl.g:912:2: ( ( 'Gold' ) )
                    {
                    // InternalComputerDsl.g:912:2: ( ( 'Gold' ) )
                    // InternalComputerDsl.g:913:3: ( 'Gold' )
                    {
                     before(grammarAccess.getRatingAccess().getGoldEnumLiteralDeclaration_2()); 
                    // InternalComputerDsl.g:914:3: ( 'Gold' )
                    // InternalComputerDsl.g:914:4: 'Gold'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getRatingAccess().getGoldEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalComputerDsl.g:918:2: ( ( 'Platinum' ) )
                    {
                    // InternalComputerDsl.g:918:2: ( ( 'Platinum' ) )
                    // InternalComputerDsl.g:919:3: ( 'Platinum' )
                    {
                     before(grammarAccess.getRatingAccess().getPlatinumEnumLiteralDeclaration_3()); 
                    // InternalComputerDsl.g:920:3: ( 'Platinum' )
                    // InternalComputerDsl.g:920:4: 'Platinum'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getRatingAccess().getPlatinumEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalComputerDsl.g:924:2: ( ( 'Titanium' ) )
                    {
                    // InternalComputerDsl.g:924:2: ( ( 'Titanium' ) )
                    // InternalComputerDsl.g:925:3: ( 'Titanium' )
                    {
                     before(grammarAccess.getRatingAccess().getTitaniumEnumLiteralDeclaration_4()); 
                    // InternalComputerDsl.g:926:3: ( 'Titanium' )
                    // InternalComputerDsl.g:926:4: 'Titanium'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getRatingAccess().getTitaniumEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rating__Alternatives"


    // $ANTLR start "rule__PackageDeclaration__Group__0"
    // InternalComputerDsl.g:934:1: rule__PackageDeclaration__Group__0 : rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 ;
    public final void rule__PackageDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:938:1: ( rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1 )
            // InternalComputerDsl.g:939:2: rule__PackageDeclaration__Group__0__Impl rule__PackageDeclaration__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__PackageDeclaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__0"


    // $ANTLR start "rule__PackageDeclaration__Group__0__Impl"
    // InternalComputerDsl.g:946:1: rule__PackageDeclaration__Group__0__Impl : ( 'package' ) ;
    public final void rule__PackageDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:950:1: ( ( 'package' ) )
            // InternalComputerDsl.g:951:1: ( 'package' )
            {
            // InternalComputerDsl.g:951:1: ( 'package' )
            // InternalComputerDsl.g:952:2: 'package'
            {
             before(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getPackageDeclarationAccess().getPackageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__0__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__1"
    // InternalComputerDsl.g:961:1: rule__PackageDeclaration__Group__1 : rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 ;
    public final void rule__PackageDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:965:1: ( rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2 )
            // InternalComputerDsl.g:966:2: rule__PackageDeclaration__Group__1__Impl rule__PackageDeclaration__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__PackageDeclaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__1"


    // $ANTLR start "rule__PackageDeclaration__Group__1__Impl"
    // InternalComputerDsl.g:973:1: rule__PackageDeclaration__Group__1__Impl : ( ( rule__PackageDeclaration__NameAssignment_1 ) ) ;
    public final void rule__PackageDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:977:1: ( ( ( rule__PackageDeclaration__NameAssignment_1 ) ) )
            // InternalComputerDsl.g:978:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            {
            // InternalComputerDsl.g:978:1: ( ( rule__PackageDeclaration__NameAssignment_1 ) )
            // InternalComputerDsl.g:979:2: ( rule__PackageDeclaration__NameAssignment_1 )
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 
            // InternalComputerDsl.g:980:2: ( rule__PackageDeclaration__NameAssignment_1 )
            // InternalComputerDsl.g:980:3: rule__PackageDeclaration__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPackageDeclarationAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__1__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__2"
    // InternalComputerDsl.g:988:1: rule__PackageDeclaration__Group__2 : rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3 ;
    public final void rule__PackageDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:992:1: ( rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3 )
            // InternalComputerDsl.g:993:2: rule__PackageDeclaration__Group__2__Impl rule__PackageDeclaration__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__PackageDeclaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__2"


    // $ANTLR start "rule__PackageDeclaration__Group__2__Impl"
    // InternalComputerDsl.g:1000:1: rule__PackageDeclaration__Group__2__Impl : ( '{' ) ;
    public final void rule__PackageDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1004:1: ( ( '{' ) )
            // InternalComputerDsl.g:1005:1: ( '{' )
            {
            // InternalComputerDsl.g:1005:1: ( '{' )
            // InternalComputerDsl.g:1006:2: '{'
            {
             before(grammarAccess.getPackageDeclarationAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getPackageDeclarationAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__2__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__3"
    // InternalComputerDsl.g:1015:1: rule__PackageDeclaration__Group__3 : rule__PackageDeclaration__Group__3__Impl rule__PackageDeclaration__Group__4 ;
    public final void rule__PackageDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1019:1: ( rule__PackageDeclaration__Group__3__Impl rule__PackageDeclaration__Group__4 )
            // InternalComputerDsl.g:1020:2: rule__PackageDeclaration__Group__3__Impl rule__PackageDeclaration__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__PackageDeclaration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__3"


    // $ANTLR start "rule__PackageDeclaration__Group__3__Impl"
    // InternalComputerDsl.g:1027:1: rule__PackageDeclaration__Group__3__Impl : ( ( rule__PackageDeclaration__ElementsAssignment_3 )* ) ;
    public final void rule__PackageDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1031:1: ( ( ( rule__PackageDeclaration__ElementsAssignment_3 )* ) )
            // InternalComputerDsl.g:1032:1: ( ( rule__PackageDeclaration__ElementsAssignment_3 )* )
            {
            // InternalComputerDsl.g:1032:1: ( ( rule__PackageDeclaration__ElementsAssignment_3 )* )
            // InternalComputerDsl.g:1033:2: ( rule__PackageDeclaration__ElementsAssignment_3 )*
            {
             before(grammarAccess.getPackageDeclarationAccess().getElementsAssignment_3()); 
            // InternalComputerDsl.g:1034:2: ( rule__PackageDeclaration__ElementsAssignment_3 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=11 && LA12_0<=14)||LA12_0==43||LA12_0==46||(LA12_0>=49 && LA12_0<=55)||LA12_0==57) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalComputerDsl.g:1034:3: rule__PackageDeclaration__ElementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__PackageDeclaration__ElementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getPackageDeclarationAccess().getElementsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__3__Impl"


    // $ANTLR start "rule__PackageDeclaration__Group__4"
    // InternalComputerDsl.g:1042:1: rule__PackageDeclaration__Group__4 : rule__PackageDeclaration__Group__4__Impl ;
    public final void rule__PackageDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1046:1: ( rule__PackageDeclaration__Group__4__Impl )
            // InternalComputerDsl.g:1047:2: rule__PackageDeclaration__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PackageDeclaration__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__4"


    // $ANTLR start "rule__PackageDeclaration__Group__4__Impl"
    // InternalComputerDsl.g:1053:1: rule__PackageDeclaration__Group__4__Impl : ( '}' ) ;
    public final void rule__PackageDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1057:1: ( ( '}' ) )
            // InternalComputerDsl.g:1058:1: ( '}' )
            {
            // InternalComputerDsl.g:1058:1: ( '}' )
            // InternalComputerDsl.g:1059:2: '}'
            {
             before(grammarAccess.getPackageDeclarationAccess().getRightCurlyBracketKeyword_4()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getPackageDeclarationAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__Group__4__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalComputerDsl.g:1069:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1073:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalComputerDsl.g:1074:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // InternalComputerDsl.g:1081:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1085:1: ( ( 'import' ) )
            // InternalComputerDsl.g:1086:1: ( 'import' )
            {
            // InternalComputerDsl.g:1086:1: ( 'import' )
            // InternalComputerDsl.g:1087:2: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // InternalComputerDsl.g:1096:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1100:1: ( rule__Import__Group__1__Impl )
            // InternalComputerDsl.g:1101:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // InternalComputerDsl.g:1107:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1111:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // InternalComputerDsl.g:1112:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // InternalComputerDsl.g:1112:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // InternalComputerDsl.g:1113:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // InternalComputerDsl.g:1114:2: ( rule__Import__ImportedNamespaceAssignment_1 )
            // InternalComputerDsl.g:1114:3: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__ImportedNamespaceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalComputerDsl.g:1123:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1127:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalComputerDsl.g:1128:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalComputerDsl.g:1135:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1139:1: ( ( RULE_ID ) )
            // InternalComputerDsl.g:1140:1: ( RULE_ID )
            {
            // InternalComputerDsl.g:1140:1: ( RULE_ID )
            // InternalComputerDsl.g:1141:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalComputerDsl.g:1150:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1154:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalComputerDsl.g:1155:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalComputerDsl.g:1161:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1165:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalComputerDsl.g:1166:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalComputerDsl.g:1166:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalComputerDsl.g:1167:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalComputerDsl.g:1168:2: ( rule__QualifiedName__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==47) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalComputerDsl.g:1168:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalComputerDsl.g:1177:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1181:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalComputerDsl.g:1182:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalComputerDsl.g:1189:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1193:1: ( ( '.' ) )
            // InternalComputerDsl.g:1194:1: ( '.' )
            {
            // InternalComputerDsl.g:1194:1: ( '.' )
            // InternalComputerDsl.g:1195:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalComputerDsl.g:1204:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1208:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalComputerDsl.g:1209:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalComputerDsl.g:1215:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1219:1: ( ( RULE_ID ) )
            // InternalComputerDsl.g:1220:1: ( RULE_ID )
            {
            // InternalComputerDsl.g:1220:1: ( RULE_ID )
            // InternalComputerDsl.g:1221:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__0"
    // InternalComputerDsl.g:1231:1: rule__QualifiedNameWithWildcard__Group__0 : rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 ;
    public final void rule__QualifiedNameWithWildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1235:1: ( rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 )
            // InternalComputerDsl.g:1236:2: rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__QualifiedNameWithWildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedNameWithWildcard__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__0"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__0__Impl"
    // InternalComputerDsl.g:1243:1: rule__QualifiedNameWithWildcard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1247:1: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:1248:1: ( ruleQualifiedName )
            {
            // InternalComputerDsl.g:1248:1: ( ruleQualifiedName )
            // InternalComputerDsl.g:1249:2: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__0__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__1"
    // InternalComputerDsl.g:1258:1: rule__QualifiedNameWithWildcard__Group__1 : rule__QualifiedNameWithWildcard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1262:1: ( rule__QualifiedNameWithWildcard__Group__1__Impl )
            // InternalComputerDsl.g:1263:2: rule__QualifiedNameWithWildcard__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedNameWithWildcard__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__1"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__1__Impl"
    // InternalComputerDsl.g:1269:1: rule__QualifiedNameWithWildcard__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__QualifiedNameWithWildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1273:1: ( ( ( '.*' )? ) )
            // InternalComputerDsl.g:1274:1: ( ( '.*' )? )
            {
            // InternalComputerDsl.g:1274:1: ( ( '.*' )? )
            // InternalComputerDsl.g:1275:2: ( '.*' )?
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
            // InternalComputerDsl.g:1276:2: ( '.*' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==48) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalComputerDsl.g:1276:3: '.*'
                    {
                    match(input,48,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__1__Impl"


    // $ANTLR start "rule__Computer__Group__0"
    // InternalComputerDsl.g:1285:1: rule__Computer__Group__0 : rule__Computer__Group__0__Impl rule__Computer__Group__1 ;
    public final void rule__Computer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1289:1: ( rule__Computer__Group__0__Impl rule__Computer__Group__1 )
            // InternalComputerDsl.g:1290:2: rule__Computer__Group__0__Impl rule__Computer__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Computer__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__0"


    // $ANTLR start "rule__Computer__Group__0__Impl"
    // InternalComputerDsl.g:1297:1: rule__Computer__Group__0__Impl : ( 'computer' ) ;
    public final void rule__Computer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1301:1: ( ( 'computer' ) )
            // InternalComputerDsl.g:1302:1: ( 'computer' )
            {
            // InternalComputerDsl.g:1302:1: ( 'computer' )
            // InternalComputerDsl.g:1303:2: 'computer'
            {
             before(grammarAccess.getComputerAccess().getComputerKeyword_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getComputerAccess().getComputerKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__0__Impl"


    // $ANTLR start "rule__Computer__Group__1"
    // InternalComputerDsl.g:1312:1: rule__Computer__Group__1 : rule__Computer__Group__1__Impl rule__Computer__Group__2 ;
    public final void rule__Computer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1316:1: ( rule__Computer__Group__1__Impl rule__Computer__Group__2 )
            // InternalComputerDsl.g:1317:2: rule__Computer__Group__1__Impl rule__Computer__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Computer__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__1"


    // $ANTLR start "rule__Computer__Group__1__Impl"
    // InternalComputerDsl.g:1324:1: rule__Computer__Group__1__Impl : ( ( rule__Computer__NameAssignment_1 ) ) ;
    public final void rule__Computer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1328:1: ( ( ( rule__Computer__NameAssignment_1 ) ) )
            // InternalComputerDsl.g:1329:1: ( ( rule__Computer__NameAssignment_1 ) )
            {
            // InternalComputerDsl.g:1329:1: ( ( rule__Computer__NameAssignment_1 ) )
            // InternalComputerDsl.g:1330:2: ( rule__Computer__NameAssignment_1 )
            {
             before(grammarAccess.getComputerAccess().getNameAssignment_1()); 
            // InternalComputerDsl.g:1331:2: ( rule__Computer__NameAssignment_1 )
            // InternalComputerDsl.g:1331:3: rule__Computer__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Computer__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getComputerAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__1__Impl"


    // $ANTLR start "rule__Computer__Group__2"
    // InternalComputerDsl.g:1339:1: rule__Computer__Group__2 : rule__Computer__Group__2__Impl rule__Computer__Group__3 ;
    public final void rule__Computer__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1343:1: ( rule__Computer__Group__2__Impl rule__Computer__Group__3 )
            // InternalComputerDsl.g:1344:2: rule__Computer__Group__2__Impl rule__Computer__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__Computer__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__2"


    // $ANTLR start "rule__Computer__Group__2__Impl"
    // InternalComputerDsl.g:1351:1: rule__Computer__Group__2__Impl : ( '{' ) ;
    public final void rule__Computer__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1355:1: ( ( '{' ) )
            // InternalComputerDsl.g:1356:1: ( '{' )
            {
            // InternalComputerDsl.g:1356:1: ( '{' )
            // InternalComputerDsl.g:1357:2: '{'
            {
             before(grammarAccess.getComputerAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getComputerAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__2__Impl"


    // $ANTLR start "rule__Computer__Group__3"
    // InternalComputerDsl.g:1366:1: rule__Computer__Group__3 : rule__Computer__Group__3__Impl rule__Computer__Group__4 ;
    public final void rule__Computer__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1370:1: ( rule__Computer__Group__3__Impl rule__Computer__Group__4 )
            // InternalComputerDsl.g:1371:2: rule__Computer__Group__3__Impl rule__Computer__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__Computer__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__3"


    // $ANTLR start "rule__Computer__Group__3__Impl"
    // InternalComputerDsl.g:1378:1: rule__Computer__Group__3__Impl : ( 'motherboard' ) ;
    public final void rule__Computer__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1382:1: ( ( 'motherboard' ) )
            // InternalComputerDsl.g:1383:1: ( 'motherboard' )
            {
            // InternalComputerDsl.g:1383:1: ( 'motherboard' )
            // InternalComputerDsl.g:1384:2: 'motherboard'
            {
             before(grammarAccess.getComputerAccess().getMotherboardKeyword_3()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getComputerAccess().getMotherboardKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__3__Impl"


    // $ANTLR start "rule__Computer__Group__4"
    // InternalComputerDsl.g:1393:1: rule__Computer__Group__4 : rule__Computer__Group__4__Impl rule__Computer__Group__5 ;
    public final void rule__Computer__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1397:1: ( rule__Computer__Group__4__Impl rule__Computer__Group__5 )
            // InternalComputerDsl.g:1398:2: rule__Computer__Group__4__Impl rule__Computer__Group__5
            {
            pushFollow(FOLLOW_11);
            rule__Computer__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__4"


    // $ANTLR start "rule__Computer__Group__4__Impl"
    // InternalComputerDsl.g:1405:1: rule__Computer__Group__4__Impl : ( ( rule__Computer__MotherboardAssignment_4 ) ) ;
    public final void rule__Computer__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1409:1: ( ( ( rule__Computer__MotherboardAssignment_4 ) ) )
            // InternalComputerDsl.g:1410:1: ( ( rule__Computer__MotherboardAssignment_4 ) )
            {
            // InternalComputerDsl.g:1410:1: ( ( rule__Computer__MotherboardAssignment_4 ) )
            // InternalComputerDsl.g:1411:2: ( rule__Computer__MotherboardAssignment_4 )
            {
             before(grammarAccess.getComputerAccess().getMotherboardAssignment_4()); 
            // InternalComputerDsl.g:1412:2: ( rule__Computer__MotherboardAssignment_4 )
            // InternalComputerDsl.g:1412:3: rule__Computer__MotherboardAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Computer__MotherboardAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getComputerAccess().getMotherboardAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__4__Impl"


    // $ANTLR start "rule__Computer__Group__5"
    // InternalComputerDsl.g:1420:1: rule__Computer__Group__5 : rule__Computer__Group__5__Impl rule__Computer__Group__6 ;
    public final void rule__Computer__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1424:1: ( rule__Computer__Group__5__Impl rule__Computer__Group__6 )
            // InternalComputerDsl.g:1425:2: rule__Computer__Group__5__Impl rule__Computer__Group__6
            {
            pushFollow(FOLLOW_4);
            rule__Computer__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__5"


    // $ANTLR start "rule__Computer__Group__5__Impl"
    // InternalComputerDsl.g:1432:1: rule__Computer__Group__5__Impl : ( 'processor' ) ;
    public final void rule__Computer__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1436:1: ( ( 'processor' ) )
            // InternalComputerDsl.g:1437:1: ( 'processor' )
            {
            // InternalComputerDsl.g:1437:1: ( 'processor' )
            // InternalComputerDsl.g:1438:2: 'processor'
            {
             before(grammarAccess.getComputerAccess().getProcessorKeyword_5()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getComputerAccess().getProcessorKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__5__Impl"


    // $ANTLR start "rule__Computer__Group__6"
    // InternalComputerDsl.g:1447:1: rule__Computer__Group__6 : rule__Computer__Group__6__Impl rule__Computer__Group__7 ;
    public final void rule__Computer__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1451:1: ( rule__Computer__Group__6__Impl rule__Computer__Group__7 )
            // InternalComputerDsl.g:1452:2: rule__Computer__Group__6__Impl rule__Computer__Group__7
            {
            pushFollow(FOLLOW_12);
            rule__Computer__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__6"


    // $ANTLR start "rule__Computer__Group__6__Impl"
    // InternalComputerDsl.g:1459:1: rule__Computer__Group__6__Impl : ( ( rule__Computer__ProcessorAssignment_6 ) ) ;
    public final void rule__Computer__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1463:1: ( ( ( rule__Computer__ProcessorAssignment_6 ) ) )
            // InternalComputerDsl.g:1464:1: ( ( rule__Computer__ProcessorAssignment_6 ) )
            {
            // InternalComputerDsl.g:1464:1: ( ( rule__Computer__ProcessorAssignment_6 ) )
            // InternalComputerDsl.g:1465:2: ( rule__Computer__ProcessorAssignment_6 )
            {
             before(grammarAccess.getComputerAccess().getProcessorAssignment_6()); 
            // InternalComputerDsl.g:1466:2: ( rule__Computer__ProcessorAssignment_6 )
            // InternalComputerDsl.g:1466:3: rule__Computer__ProcessorAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Computer__ProcessorAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getComputerAccess().getProcessorAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__6__Impl"


    // $ANTLR start "rule__Computer__Group__7"
    // InternalComputerDsl.g:1474:1: rule__Computer__Group__7 : rule__Computer__Group__7__Impl rule__Computer__Group__8 ;
    public final void rule__Computer__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1478:1: ( rule__Computer__Group__7__Impl rule__Computer__Group__8 )
            // InternalComputerDsl.g:1479:2: rule__Computer__Group__7__Impl rule__Computer__Group__8
            {
            pushFollow(FOLLOW_12);
            rule__Computer__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__7"


    // $ANTLR start "rule__Computer__Group__7__Impl"
    // InternalComputerDsl.g:1486:1: rule__Computer__Group__7__Impl : ( ( rule__Computer__Group_7__0 )? ) ;
    public final void rule__Computer__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1490:1: ( ( ( rule__Computer__Group_7__0 )? ) )
            // InternalComputerDsl.g:1491:1: ( ( rule__Computer__Group_7__0 )? )
            {
            // InternalComputerDsl.g:1491:1: ( ( rule__Computer__Group_7__0 )? )
            // InternalComputerDsl.g:1492:2: ( rule__Computer__Group_7__0 )?
            {
             before(grammarAccess.getComputerAccess().getGroup_7()); 
            // InternalComputerDsl.g:1493:2: ( rule__Computer__Group_7__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==55) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalComputerDsl.g:1493:3: rule__Computer__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Computer__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getComputerAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__7__Impl"


    // $ANTLR start "rule__Computer__Group__8"
    // InternalComputerDsl.g:1501:1: rule__Computer__Group__8 : rule__Computer__Group__8__Impl rule__Computer__Group__9 ;
    public final void rule__Computer__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1505:1: ( rule__Computer__Group__8__Impl rule__Computer__Group__9 )
            // InternalComputerDsl.g:1506:2: rule__Computer__Group__8__Impl rule__Computer__Group__9
            {
            pushFollow(FOLLOW_4);
            rule__Computer__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__8"


    // $ANTLR start "rule__Computer__Group__8__Impl"
    // InternalComputerDsl.g:1513:1: rule__Computer__Group__8__Impl : ( 'memory' ) ;
    public final void rule__Computer__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1517:1: ( ( 'memory' ) )
            // InternalComputerDsl.g:1518:1: ( 'memory' )
            {
            // InternalComputerDsl.g:1518:1: ( 'memory' )
            // InternalComputerDsl.g:1519:2: 'memory'
            {
             before(grammarAccess.getComputerAccess().getMemoryKeyword_8()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getComputerAccess().getMemoryKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__8__Impl"


    // $ANTLR start "rule__Computer__Group__9"
    // InternalComputerDsl.g:1528:1: rule__Computer__Group__9 : rule__Computer__Group__9__Impl rule__Computer__Group__10 ;
    public final void rule__Computer__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1532:1: ( rule__Computer__Group__9__Impl rule__Computer__Group__10 )
            // InternalComputerDsl.g:1533:2: rule__Computer__Group__9__Impl rule__Computer__Group__10
            {
            pushFollow(FOLLOW_13);
            rule__Computer__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__9"


    // $ANTLR start "rule__Computer__Group__9__Impl"
    // InternalComputerDsl.g:1540:1: rule__Computer__Group__9__Impl : ( ( rule__Computer__MemoryAssignment_9 ) ) ;
    public final void rule__Computer__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1544:1: ( ( ( rule__Computer__MemoryAssignment_9 ) ) )
            // InternalComputerDsl.g:1545:1: ( ( rule__Computer__MemoryAssignment_9 ) )
            {
            // InternalComputerDsl.g:1545:1: ( ( rule__Computer__MemoryAssignment_9 ) )
            // InternalComputerDsl.g:1546:2: ( rule__Computer__MemoryAssignment_9 )
            {
             before(grammarAccess.getComputerAccess().getMemoryAssignment_9()); 
            // InternalComputerDsl.g:1547:2: ( rule__Computer__MemoryAssignment_9 )
            // InternalComputerDsl.g:1547:3: rule__Computer__MemoryAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Computer__MemoryAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getComputerAccess().getMemoryAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__9__Impl"


    // $ANTLR start "rule__Computer__Group__10"
    // InternalComputerDsl.g:1555:1: rule__Computer__Group__10 : rule__Computer__Group__10__Impl rule__Computer__Group__11 ;
    public final void rule__Computer__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1559:1: ( rule__Computer__Group__10__Impl rule__Computer__Group__11 )
            // InternalComputerDsl.g:1560:2: rule__Computer__Group__10__Impl rule__Computer__Group__11
            {
            pushFollow(FOLLOW_13);
            rule__Computer__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__10"


    // $ANTLR start "rule__Computer__Group__10__Impl"
    // InternalComputerDsl.g:1567:1: rule__Computer__Group__10__Impl : ( ( rule__Computer__Group_10__0 )* ) ;
    public final void rule__Computer__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1571:1: ( ( ( rule__Computer__Group_10__0 )* ) )
            // InternalComputerDsl.g:1572:1: ( ( rule__Computer__Group_10__0 )* )
            {
            // InternalComputerDsl.g:1572:1: ( ( rule__Computer__Group_10__0 )* )
            // InternalComputerDsl.g:1573:2: ( rule__Computer__Group_10__0 )*
            {
             before(grammarAccess.getComputerAccess().getGroup_10()); 
            // InternalComputerDsl.g:1574:2: ( rule__Computer__Group_10__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==56) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalComputerDsl.g:1574:3: rule__Computer__Group_10__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__Computer__Group_10__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getComputerAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__10__Impl"


    // $ANTLR start "rule__Computer__Group__11"
    // InternalComputerDsl.g:1582:1: rule__Computer__Group__11 : rule__Computer__Group__11__Impl rule__Computer__Group__12 ;
    public final void rule__Computer__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1586:1: ( rule__Computer__Group__11__Impl rule__Computer__Group__12 )
            // InternalComputerDsl.g:1587:2: rule__Computer__Group__11__Impl rule__Computer__Group__12
            {
            pushFollow(FOLLOW_4);
            rule__Computer__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__11"


    // $ANTLR start "rule__Computer__Group__11__Impl"
    // InternalComputerDsl.g:1594:1: rule__Computer__Group__11__Impl : ( 'storage' ) ;
    public final void rule__Computer__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1598:1: ( ( 'storage' ) )
            // InternalComputerDsl.g:1599:1: ( 'storage' )
            {
            // InternalComputerDsl.g:1599:1: ( 'storage' )
            // InternalComputerDsl.g:1600:2: 'storage'
            {
             before(grammarAccess.getComputerAccess().getStorageKeyword_11()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getComputerAccess().getStorageKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__11__Impl"


    // $ANTLR start "rule__Computer__Group__12"
    // InternalComputerDsl.g:1609:1: rule__Computer__Group__12 : rule__Computer__Group__12__Impl rule__Computer__Group__13 ;
    public final void rule__Computer__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1613:1: ( rule__Computer__Group__12__Impl rule__Computer__Group__13 )
            // InternalComputerDsl.g:1614:2: rule__Computer__Group__12__Impl rule__Computer__Group__13
            {
            pushFollow(FOLLOW_15);
            rule__Computer__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__12"


    // $ANTLR start "rule__Computer__Group__12__Impl"
    // InternalComputerDsl.g:1621:1: rule__Computer__Group__12__Impl : ( ( rule__Computer__StorageAssignment_12 ) ) ;
    public final void rule__Computer__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1625:1: ( ( ( rule__Computer__StorageAssignment_12 ) ) )
            // InternalComputerDsl.g:1626:1: ( ( rule__Computer__StorageAssignment_12 ) )
            {
            // InternalComputerDsl.g:1626:1: ( ( rule__Computer__StorageAssignment_12 ) )
            // InternalComputerDsl.g:1627:2: ( rule__Computer__StorageAssignment_12 )
            {
             before(grammarAccess.getComputerAccess().getStorageAssignment_12()); 
            // InternalComputerDsl.g:1628:2: ( rule__Computer__StorageAssignment_12 )
            // InternalComputerDsl.g:1628:3: rule__Computer__StorageAssignment_12
            {
            pushFollow(FOLLOW_2);
            rule__Computer__StorageAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getComputerAccess().getStorageAssignment_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__12__Impl"


    // $ANTLR start "rule__Computer__Group__13"
    // InternalComputerDsl.g:1636:1: rule__Computer__Group__13 : rule__Computer__Group__13__Impl rule__Computer__Group__14 ;
    public final void rule__Computer__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1640:1: ( rule__Computer__Group__13__Impl rule__Computer__Group__14 )
            // InternalComputerDsl.g:1641:2: rule__Computer__Group__13__Impl rule__Computer__Group__14
            {
            pushFollow(FOLLOW_15);
            rule__Computer__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__13"


    // $ANTLR start "rule__Computer__Group__13__Impl"
    // InternalComputerDsl.g:1648:1: rule__Computer__Group__13__Impl : ( ( rule__Computer__Group_13__0 )* ) ;
    public final void rule__Computer__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1652:1: ( ( ( rule__Computer__Group_13__0 )* ) )
            // InternalComputerDsl.g:1653:1: ( ( rule__Computer__Group_13__0 )* )
            {
            // InternalComputerDsl.g:1653:1: ( ( rule__Computer__Group_13__0 )* )
            // InternalComputerDsl.g:1654:2: ( rule__Computer__Group_13__0 )*
            {
             before(grammarAccess.getComputerAccess().getGroup_13()); 
            // InternalComputerDsl.g:1655:2: ( rule__Computer__Group_13__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==56) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalComputerDsl.g:1655:3: rule__Computer__Group_13__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__Computer__Group_13__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getComputerAccess().getGroup_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__13__Impl"


    // $ANTLR start "rule__Computer__Group__14"
    // InternalComputerDsl.g:1663:1: rule__Computer__Group__14 : rule__Computer__Group__14__Impl rule__Computer__Group__15 ;
    public final void rule__Computer__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1667:1: ( rule__Computer__Group__14__Impl rule__Computer__Group__15 )
            // InternalComputerDsl.g:1668:2: rule__Computer__Group__14__Impl rule__Computer__Group__15
            {
            pushFollow(FOLLOW_15);
            rule__Computer__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__14"


    // $ANTLR start "rule__Computer__Group__14__Impl"
    // InternalComputerDsl.g:1675:1: rule__Computer__Group__14__Impl : ( ( rule__Computer__Group_14__0 )? ) ;
    public final void rule__Computer__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1679:1: ( ( ( rule__Computer__Group_14__0 )? ) )
            // InternalComputerDsl.g:1680:1: ( ( rule__Computer__Group_14__0 )? )
            {
            // InternalComputerDsl.g:1680:1: ( ( rule__Computer__Group_14__0 )? )
            // InternalComputerDsl.g:1681:2: ( rule__Computer__Group_14__0 )?
            {
             before(grammarAccess.getComputerAccess().getGroup_14()); 
            // InternalComputerDsl.g:1682:2: ( rule__Computer__Group_14__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==57) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalComputerDsl.g:1682:3: rule__Computer__Group_14__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Computer__Group_14__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getComputerAccess().getGroup_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__14__Impl"


    // $ANTLR start "rule__Computer__Group__15"
    // InternalComputerDsl.g:1690:1: rule__Computer__Group__15 : rule__Computer__Group__15__Impl rule__Computer__Group__16 ;
    public final void rule__Computer__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1694:1: ( rule__Computer__Group__15__Impl rule__Computer__Group__16 )
            // InternalComputerDsl.g:1695:2: rule__Computer__Group__15__Impl rule__Computer__Group__16
            {
            pushFollow(FOLLOW_15);
            rule__Computer__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__16();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__15"


    // $ANTLR start "rule__Computer__Group__15__Impl"
    // InternalComputerDsl.g:1702:1: rule__Computer__Group__15__Impl : ( ( rule__Computer__Group_15__0 )? ) ;
    public final void rule__Computer__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1706:1: ( ( ( rule__Computer__Group_15__0 )? ) )
            // InternalComputerDsl.g:1707:1: ( ( rule__Computer__Group_15__0 )? )
            {
            // InternalComputerDsl.g:1707:1: ( ( rule__Computer__Group_15__0 )? )
            // InternalComputerDsl.g:1708:2: ( rule__Computer__Group_15__0 )?
            {
             before(grammarAccess.getComputerAccess().getGroup_15()); 
            // InternalComputerDsl.g:1709:2: ( rule__Computer__Group_15__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==58) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalComputerDsl.g:1709:3: rule__Computer__Group_15__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Computer__Group_15__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getComputerAccess().getGroup_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__15__Impl"


    // $ANTLR start "rule__Computer__Group__16"
    // InternalComputerDsl.g:1717:1: rule__Computer__Group__16 : rule__Computer__Group__16__Impl rule__Computer__Group__17 ;
    public final void rule__Computer__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1721:1: ( rule__Computer__Group__16__Impl rule__Computer__Group__17 )
            // InternalComputerDsl.g:1722:2: rule__Computer__Group__16__Impl rule__Computer__Group__17
            {
            pushFollow(FOLLOW_4);
            rule__Computer__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__17();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__16"


    // $ANTLR start "rule__Computer__Group__16__Impl"
    // InternalComputerDsl.g:1729:1: rule__Computer__Group__16__Impl : ( 'psu' ) ;
    public final void rule__Computer__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1733:1: ( ( 'psu' ) )
            // InternalComputerDsl.g:1734:1: ( 'psu' )
            {
            // InternalComputerDsl.g:1734:1: ( 'psu' )
            // InternalComputerDsl.g:1735:2: 'psu'
            {
             before(grammarAccess.getComputerAccess().getPsuKeyword_16()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getComputerAccess().getPsuKeyword_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__16__Impl"


    // $ANTLR start "rule__Computer__Group__17"
    // InternalComputerDsl.g:1744:1: rule__Computer__Group__17 : rule__Computer__Group__17__Impl rule__Computer__Group__18 ;
    public final void rule__Computer__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1748:1: ( rule__Computer__Group__17__Impl rule__Computer__Group__18 )
            // InternalComputerDsl.g:1749:2: rule__Computer__Group__17__Impl rule__Computer__Group__18
            {
            pushFollow(FOLLOW_16);
            rule__Computer__Group__17__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group__18();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__17"


    // $ANTLR start "rule__Computer__Group__17__Impl"
    // InternalComputerDsl.g:1756:1: rule__Computer__Group__17__Impl : ( ( rule__Computer__PowerSupplyAssignment_17 ) ) ;
    public final void rule__Computer__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1760:1: ( ( ( rule__Computer__PowerSupplyAssignment_17 ) ) )
            // InternalComputerDsl.g:1761:1: ( ( rule__Computer__PowerSupplyAssignment_17 ) )
            {
            // InternalComputerDsl.g:1761:1: ( ( rule__Computer__PowerSupplyAssignment_17 ) )
            // InternalComputerDsl.g:1762:2: ( rule__Computer__PowerSupplyAssignment_17 )
            {
             before(grammarAccess.getComputerAccess().getPowerSupplyAssignment_17()); 
            // InternalComputerDsl.g:1763:2: ( rule__Computer__PowerSupplyAssignment_17 )
            // InternalComputerDsl.g:1763:3: rule__Computer__PowerSupplyAssignment_17
            {
            pushFollow(FOLLOW_2);
            rule__Computer__PowerSupplyAssignment_17();

            state._fsp--;


            }

             after(grammarAccess.getComputerAccess().getPowerSupplyAssignment_17()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__17__Impl"


    // $ANTLR start "rule__Computer__Group__18"
    // InternalComputerDsl.g:1771:1: rule__Computer__Group__18 : rule__Computer__Group__18__Impl ;
    public final void rule__Computer__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1775:1: ( rule__Computer__Group__18__Impl )
            // InternalComputerDsl.g:1776:2: rule__Computer__Group__18__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Computer__Group__18__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__18"


    // $ANTLR start "rule__Computer__Group__18__Impl"
    // InternalComputerDsl.g:1782:1: rule__Computer__Group__18__Impl : ( '}' ) ;
    public final void rule__Computer__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1786:1: ( ( '}' ) )
            // InternalComputerDsl.g:1787:1: ( '}' )
            {
            // InternalComputerDsl.g:1787:1: ( '}' )
            // InternalComputerDsl.g:1788:2: '}'
            {
             before(grammarAccess.getComputerAccess().getRightCurlyBracketKeyword_18()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getComputerAccess().getRightCurlyBracketKeyword_18()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group__18__Impl"


    // $ANTLR start "rule__Computer__Group_7__0"
    // InternalComputerDsl.g:1798:1: rule__Computer__Group_7__0 : rule__Computer__Group_7__0__Impl rule__Computer__Group_7__1 ;
    public final void rule__Computer__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1802:1: ( rule__Computer__Group_7__0__Impl rule__Computer__Group_7__1 )
            // InternalComputerDsl.g:1803:2: rule__Computer__Group_7__0__Impl rule__Computer__Group_7__1
            {
            pushFollow(FOLLOW_4);
            rule__Computer__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_7__0"


    // $ANTLR start "rule__Computer__Group_7__0__Impl"
    // InternalComputerDsl.g:1810:1: rule__Computer__Group_7__0__Impl : ( 'graphics' ) ;
    public final void rule__Computer__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1814:1: ( ( 'graphics' ) )
            // InternalComputerDsl.g:1815:1: ( 'graphics' )
            {
            // InternalComputerDsl.g:1815:1: ( 'graphics' )
            // InternalComputerDsl.g:1816:2: 'graphics'
            {
             before(grammarAccess.getComputerAccess().getGraphicsKeyword_7_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getComputerAccess().getGraphicsKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_7__0__Impl"


    // $ANTLR start "rule__Computer__Group_7__1"
    // InternalComputerDsl.g:1825:1: rule__Computer__Group_7__1 : rule__Computer__Group_7__1__Impl ;
    public final void rule__Computer__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1829:1: ( rule__Computer__Group_7__1__Impl )
            // InternalComputerDsl.g:1830:2: rule__Computer__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Computer__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_7__1"


    // $ANTLR start "rule__Computer__Group_7__1__Impl"
    // InternalComputerDsl.g:1836:1: rule__Computer__Group_7__1__Impl : ( ( rule__Computer__GraphicsCardAssignment_7_1 ) ) ;
    public final void rule__Computer__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1840:1: ( ( ( rule__Computer__GraphicsCardAssignment_7_1 ) ) )
            // InternalComputerDsl.g:1841:1: ( ( rule__Computer__GraphicsCardAssignment_7_1 ) )
            {
            // InternalComputerDsl.g:1841:1: ( ( rule__Computer__GraphicsCardAssignment_7_1 ) )
            // InternalComputerDsl.g:1842:2: ( rule__Computer__GraphicsCardAssignment_7_1 )
            {
             before(grammarAccess.getComputerAccess().getGraphicsCardAssignment_7_1()); 
            // InternalComputerDsl.g:1843:2: ( rule__Computer__GraphicsCardAssignment_7_1 )
            // InternalComputerDsl.g:1843:3: rule__Computer__GraphicsCardAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__Computer__GraphicsCardAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getComputerAccess().getGraphicsCardAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_7__1__Impl"


    // $ANTLR start "rule__Computer__Group_10__0"
    // InternalComputerDsl.g:1852:1: rule__Computer__Group_10__0 : rule__Computer__Group_10__0__Impl rule__Computer__Group_10__1 ;
    public final void rule__Computer__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1856:1: ( rule__Computer__Group_10__0__Impl rule__Computer__Group_10__1 )
            // InternalComputerDsl.g:1857:2: rule__Computer__Group_10__0__Impl rule__Computer__Group_10__1
            {
            pushFollow(FOLLOW_4);
            rule__Computer__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_10__0"


    // $ANTLR start "rule__Computer__Group_10__0__Impl"
    // InternalComputerDsl.g:1864:1: rule__Computer__Group_10__0__Impl : ( ',' ) ;
    public final void rule__Computer__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1868:1: ( ( ',' ) )
            // InternalComputerDsl.g:1869:1: ( ',' )
            {
            // InternalComputerDsl.g:1869:1: ( ',' )
            // InternalComputerDsl.g:1870:2: ','
            {
             before(grammarAccess.getComputerAccess().getCommaKeyword_10_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getComputerAccess().getCommaKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_10__0__Impl"


    // $ANTLR start "rule__Computer__Group_10__1"
    // InternalComputerDsl.g:1879:1: rule__Computer__Group_10__1 : rule__Computer__Group_10__1__Impl ;
    public final void rule__Computer__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1883:1: ( rule__Computer__Group_10__1__Impl )
            // InternalComputerDsl.g:1884:2: rule__Computer__Group_10__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Computer__Group_10__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_10__1"


    // $ANTLR start "rule__Computer__Group_10__1__Impl"
    // InternalComputerDsl.g:1890:1: rule__Computer__Group_10__1__Impl : ( ( rule__Computer__MemoryAssignment_10_1 ) ) ;
    public final void rule__Computer__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1894:1: ( ( ( rule__Computer__MemoryAssignment_10_1 ) ) )
            // InternalComputerDsl.g:1895:1: ( ( rule__Computer__MemoryAssignment_10_1 ) )
            {
            // InternalComputerDsl.g:1895:1: ( ( rule__Computer__MemoryAssignment_10_1 ) )
            // InternalComputerDsl.g:1896:2: ( rule__Computer__MemoryAssignment_10_1 )
            {
             before(grammarAccess.getComputerAccess().getMemoryAssignment_10_1()); 
            // InternalComputerDsl.g:1897:2: ( rule__Computer__MemoryAssignment_10_1 )
            // InternalComputerDsl.g:1897:3: rule__Computer__MemoryAssignment_10_1
            {
            pushFollow(FOLLOW_2);
            rule__Computer__MemoryAssignment_10_1();

            state._fsp--;


            }

             after(grammarAccess.getComputerAccess().getMemoryAssignment_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_10__1__Impl"


    // $ANTLR start "rule__Computer__Group_13__0"
    // InternalComputerDsl.g:1906:1: rule__Computer__Group_13__0 : rule__Computer__Group_13__0__Impl rule__Computer__Group_13__1 ;
    public final void rule__Computer__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1910:1: ( rule__Computer__Group_13__0__Impl rule__Computer__Group_13__1 )
            // InternalComputerDsl.g:1911:2: rule__Computer__Group_13__0__Impl rule__Computer__Group_13__1
            {
            pushFollow(FOLLOW_4);
            rule__Computer__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group_13__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_13__0"


    // $ANTLR start "rule__Computer__Group_13__0__Impl"
    // InternalComputerDsl.g:1918:1: rule__Computer__Group_13__0__Impl : ( ',' ) ;
    public final void rule__Computer__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1922:1: ( ( ',' ) )
            // InternalComputerDsl.g:1923:1: ( ',' )
            {
            // InternalComputerDsl.g:1923:1: ( ',' )
            // InternalComputerDsl.g:1924:2: ','
            {
             before(grammarAccess.getComputerAccess().getCommaKeyword_13_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getComputerAccess().getCommaKeyword_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_13__0__Impl"


    // $ANTLR start "rule__Computer__Group_13__1"
    // InternalComputerDsl.g:1933:1: rule__Computer__Group_13__1 : rule__Computer__Group_13__1__Impl ;
    public final void rule__Computer__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1937:1: ( rule__Computer__Group_13__1__Impl )
            // InternalComputerDsl.g:1938:2: rule__Computer__Group_13__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Computer__Group_13__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_13__1"


    // $ANTLR start "rule__Computer__Group_13__1__Impl"
    // InternalComputerDsl.g:1944:1: rule__Computer__Group_13__1__Impl : ( ( rule__Computer__StorageAssignment_13_1 ) ) ;
    public final void rule__Computer__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1948:1: ( ( ( rule__Computer__StorageAssignment_13_1 ) ) )
            // InternalComputerDsl.g:1949:1: ( ( rule__Computer__StorageAssignment_13_1 ) )
            {
            // InternalComputerDsl.g:1949:1: ( ( rule__Computer__StorageAssignment_13_1 ) )
            // InternalComputerDsl.g:1950:2: ( rule__Computer__StorageAssignment_13_1 )
            {
             before(grammarAccess.getComputerAccess().getStorageAssignment_13_1()); 
            // InternalComputerDsl.g:1951:2: ( rule__Computer__StorageAssignment_13_1 )
            // InternalComputerDsl.g:1951:3: rule__Computer__StorageAssignment_13_1
            {
            pushFollow(FOLLOW_2);
            rule__Computer__StorageAssignment_13_1();

            state._fsp--;


            }

             after(grammarAccess.getComputerAccess().getStorageAssignment_13_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_13__1__Impl"


    // $ANTLR start "rule__Computer__Group_14__0"
    // InternalComputerDsl.g:1960:1: rule__Computer__Group_14__0 : rule__Computer__Group_14__0__Impl rule__Computer__Group_14__1 ;
    public final void rule__Computer__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1964:1: ( rule__Computer__Group_14__0__Impl rule__Computer__Group_14__1 )
            // InternalComputerDsl.g:1965:2: rule__Computer__Group_14__0__Impl rule__Computer__Group_14__1
            {
            pushFollow(FOLLOW_4);
            rule__Computer__Group_14__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group_14__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_14__0"


    // $ANTLR start "rule__Computer__Group_14__0__Impl"
    // InternalComputerDsl.g:1972:1: rule__Computer__Group_14__0__Impl : ( 'drive' ) ;
    public final void rule__Computer__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1976:1: ( ( 'drive' ) )
            // InternalComputerDsl.g:1977:1: ( 'drive' )
            {
            // InternalComputerDsl.g:1977:1: ( 'drive' )
            // InternalComputerDsl.g:1978:2: 'drive'
            {
             before(grammarAccess.getComputerAccess().getDriveKeyword_14_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getComputerAccess().getDriveKeyword_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_14__0__Impl"


    // $ANTLR start "rule__Computer__Group_14__1"
    // InternalComputerDsl.g:1987:1: rule__Computer__Group_14__1 : rule__Computer__Group_14__1__Impl ;
    public final void rule__Computer__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:1991:1: ( rule__Computer__Group_14__1__Impl )
            // InternalComputerDsl.g:1992:2: rule__Computer__Group_14__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Computer__Group_14__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_14__1"


    // $ANTLR start "rule__Computer__Group_14__1__Impl"
    // InternalComputerDsl.g:1998:1: rule__Computer__Group_14__1__Impl : ( ( rule__Computer__DriveAssignment_14_1 ) ) ;
    public final void rule__Computer__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2002:1: ( ( ( rule__Computer__DriveAssignment_14_1 ) ) )
            // InternalComputerDsl.g:2003:1: ( ( rule__Computer__DriveAssignment_14_1 ) )
            {
            // InternalComputerDsl.g:2003:1: ( ( rule__Computer__DriveAssignment_14_1 ) )
            // InternalComputerDsl.g:2004:2: ( rule__Computer__DriveAssignment_14_1 )
            {
             before(grammarAccess.getComputerAccess().getDriveAssignment_14_1()); 
            // InternalComputerDsl.g:2005:2: ( rule__Computer__DriveAssignment_14_1 )
            // InternalComputerDsl.g:2005:3: rule__Computer__DriveAssignment_14_1
            {
            pushFollow(FOLLOW_2);
            rule__Computer__DriveAssignment_14_1();

            state._fsp--;


            }

             after(grammarAccess.getComputerAccess().getDriveAssignment_14_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_14__1__Impl"


    // $ANTLR start "rule__Computer__Group_15__0"
    // InternalComputerDsl.g:2014:1: rule__Computer__Group_15__0 : rule__Computer__Group_15__0__Impl rule__Computer__Group_15__1 ;
    public final void rule__Computer__Group_15__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2018:1: ( rule__Computer__Group_15__0__Impl rule__Computer__Group_15__1 )
            // InternalComputerDsl.g:2019:2: rule__Computer__Group_15__0__Impl rule__Computer__Group_15__1
            {
            pushFollow(FOLLOW_4);
            rule__Computer__Group_15__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group_15__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_15__0"


    // $ANTLR start "rule__Computer__Group_15__0__Impl"
    // InternalComputerDsl.g:2026:1: rule__Computer__Group_15__0__Impl : ( 'peripherals' ) ;
    public final void rule__Computer__Group_15__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2030:1: ( ( 'peripherals' ) )
            // InternalComputerDsl.g:2031:1: ( 'peripherals' )
            {
            // InternalComputerDsl.g:2031:1: ( 'peripherals' )
            // InternalComputerDsl.g:2032:2: 'peripherals'
            {
             before(grammarAccess.getComputerAccess().getPeripheralsKeyword_15_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getComputerAccess().getPeripheralsKeyword_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_15__0__Impl"


    // $ANTLR start "rule__Computer__Group_15__1"
    // InternalComputerDsl.g:2041:1: rule__Computer__Group_15__1 : rule__Computer__Group_15__1__Impl rule__Computer__Group_15__2 ;
    public final void rule__Computer__Group_15__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2045:1: ( rule__Computer__Group_15__1__Impl rule__Computer__Group_15__2 )
            // InternalComputerDsl.g:2046:2: rule__Computer__Group_15__1__Impl rule__Computer__Group_15__2
            {
            pushFollow(FOLLOW_17);
            rule__Computer__Group_15__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group_15__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_15__1"


    // $ANTLR start "rule__Computer__Group_15__1__Impl"
    // InternalComputerDsl.g:2053:1: rule__Computer__Group_15__1__Impl : ( ( rule__Computer__PeripheralsAssignment_15_1 ) ) ;
    public final void rule__Computer__Group_15__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2057:1: ( ( ( rule__Computer__PeripheralsAssignment_15_1 ) ) )
            // InternalComputerDsl.g:2058:1: ( ( rule__Computer__PeripheralsAssignment_15_1 ) )
            {
            // InternalComputerDsl.g:2058:1: ( ( rule__Computer__PeripheralsAssignment_15_1 ) )
            // InternalComputerDsl.g:2059:2: ( rule__Computer__PeripheralsAssignment_15_1 )
            {
             before(grammarAccess.getComputerAccess().getPeripheralsAssignment_15_1()); 
            // InternalComputerDsl.g:2060:2: ( rule__Computer__PeripheralsAssignment_15_1 )
            // InternalComputerDsl.g:2060:3: rule__Computer__PeripheralsAssignment_15_1
            {
            pushFollow(FOLLOW_2);
            rule__Computer__PeripheralsAssignment_15_1();

            state._fsp--;


            }

             after(grammarAccess.getComputerAccess().getPeripheralsAssignment_15_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_15__1__Impl"


    // $ANTLR start "rule__Computer__Group_15__2"
    // InternalComputerDsl.g:2068:1: rule__Computer__Group_15__2 : rule__Computer__Group_15__2__Impl ;
    public final void rule__Computer__Group_15__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2072:1: ( rule__Computer__Group_15__2__Impl )
            // InternalComputerDsl.g:2073:2: rule__Computer__Group_15__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Computer__Group_15__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_15__2"


    // $ANTLR start "rule__Computer__Group_15__2__Impl"
    // InternalComputerDsl.g:2079:1: rule__Computer__Group_15__2__Impl : ( ( rule__Computer__Group_15_2__0 )* ) ;
    public final void rule__Computer__Group_15__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2083:1: ( ( ( rule__Computer__Group_15_2__0 )* ) )
            // InternalComputerDsl.g:2084:1: ( ( rule__Computer__Group_15_2__0 )* )
            {
            // InternalComputerDsl.g:2084:1: ( ( rule__Computer__Group_15_2__0 )* )
            // InternalComputerDsl.g:2085:2: ( rule__Computer__Group_15_2__0 )*
            {
             before(grammarAccess.getComputerAccess().getGroup_15_2()); 
            // InternalComputerDsl.g:2086:2: ( rule__Computer__Group_15_2__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==56) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalComputerDsl.g:2086:3: rule__Computer__Group_15_2__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__Computer__Group_15_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getComputerAccess().getGroup_15_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_15__2__Impl"


    // $ANTLR start "rule__Computer__Group_15_2__0"
    // InternalComputerDsl.g:2095:1: rule__Computer__Group_15_2__0 : rule__Computer__Group_15_2__0__Impl rule__Computer__Group_15_2__1 ;
    public final void rule__Computer__Group_15_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2099:1: ( rule__Computer__Group_15_2__0__Impl rule__Computer__Group_15_2__1 )
            // InternalComputerDsl.g:2100:2: rule__Computer__Group_15_2__0__Impl rule__Computer__Group_15_2__1
            {
            pushFollow(FOLLOW_4);
            rule__Computer__Group_15_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Computer__Group_15_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_15_2__0"


    // $ANTLR start "rule__Computer__Group_15_2__0__Impl"
    // InternalComputerDsl.g:2107:1: rule__Computer__Group_15_2__0__Impl : ( ',' ) ;
    public final void rule__Computer__Group_15_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2111:1: ( ( ',' ) )
            // InternalComputerDsl.g:2112:1: ( ',' )
            {
            // InternalComputerDsl.g:2112:1: ( ',' )
            // InternalComputerDsl.g:2113:2: ','
            {
             before(grammarAccess.getComputerAccess().getCommaKeyword_15_2_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getComputerAccess().getCommaKeyword_15_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_15_2__0__Impl"


    // $ANTLR start "rule__Computer__Group_15_2__1"
    // InternalComputerDsl.g:2122:1: rule__Computer__Group_15_2__1 : rule__Computer__Group_15_2__1__Impl ;
    public final void rule__Computer__Group_15_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2126:1: ( rule__Computer__Group_15_2__1__Impl )
            // InternalComputerDsl.g:2127:2: rule__Computer__Group_15_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Computer__Group_15_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_15_2__1"


    // $ANTLR start "rule__Computer__Group_15_2__1__Impl"
    // InternalComputerDsl.g:2133:1: rule__Computer__Group_15_2__1__Impl : ( ( rule__Computer__PeripheralsAssignment_15_2_1 ) ) ;
    public final void rule__Computer__Group_15_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2137:1: ( ( ( rule__Computer__PeripheralsAssignment_15_2_1 ) ) )
            // InternalComputerDsl.g:2138:1: ( ( rule__Computer__PeripheralsAssignment_15_2_1 ) )
            {
            // InternalComputerDsl.g:2138:1: ( ( rule__Computer__PeripheralsAssignment_15_2_1 ) )
            // InternalComputerDsl.g:2139:2: ( rule__Computer__PeripheralsAssignment_15_2_1 )
            {
             before(grammarAccess.getComputerAccess().getPeripheralsAssignment_15_2_1()); 
            // InternalComputerDsl.g:2140:2: ( rule__Computer__PeripheralsAssignment_15_2_1 )
            // InternalComputerDsl.g:2140:3: rule__Computer__PeripheralsAssignment_15_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Computer__PeripheralsAssignment_15_2_1();

            state._fsp--;


            }

             after(grammarAccess.getComputerAccess().getPeripheralsAssignment_15_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__Group_15_2__1__Impl"


    // $ANTLR start "rule__Motherboard__Group__0"
    // InternalComputerDsl.g:2149:1: rule__Motherboard__Group__0 : rule__Motherboard__Group__0__Impl rule__Motherboard__Group__1 ;
    public final void rule__Motherboard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2153:1: ( rule__Motherboard__Group__0__Impl rule__Motherboard__Group__1 )
            // InternalComputerDsl.g:2154:2: rule__Motherboard__Group__0__Impl rule__Motherboard__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Motherboard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Motherboard__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__0"


    // $ANTLR start "rule__Motherboard__Group__0__Impl"
    // InternalComputerDsl.g:2161:1: rule__Motherboard__Group__0__Impl : ( 'motherboard' ) ;
    public final void rule__Motherboard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2165:1: ( ( 'motherboard' ) )
            // InternalComputerDsl.g:2166:1: ( 'motherboard' )
            {
            // InternalComputerDsl.g:2166:1: ( 'motherboard' )
            // InternalComputerDsl.g:2167:2: 'motherboard'
            {
             before(grammarAccess.getMotherboardAccess().getMotherboardKeyword_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getMotherboardAccess().getMotherboardKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__0__Impl"


    // $ANTLR start "rule__Motherboard__Group__1"
    // InternalComputerDsl.g:2176:1: rule__Motherboard__Group__1 : rule__Motherboard__Group__1__Impl rule__Motherboard__Group__2 ;
    public final void rule__Motherboard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2180:1: ( rule__Motherboard__Group__1__Impl rule__Motherboard__Group__2 )
            // InternalComputerDsl.g:2181:2: rule__Motherboard__Group__1__Impl rule__Motherboard__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Motherboard__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Motherboard__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__1"


    // $ANTLR start "rule__Motherboard__Group__1__Impl"
    // InternalComputerDsl.g:2188:1: rule__Motherboard__Group__1__Impl : ( ( rule__Motherboard__NameAssignment_1 ) ) ;
    public final void rule__Motherboard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2192:1: ( ( ( rule__Motherboard__NameAssignment_1 ) ) )
            // InternalComputerDsl.g:2193:1: ( ( rule__Motherboard__NameAssignment_1 ) )
            {
            // InternalComputerDsl.g:2193:1: ( ( rule__Motherboard__NameAssignment_1 ) )
            // InternalComputerDsl.g:2194:2: ( rule__Motherboard__NameAssignment_1 )
            {
             before(grammarAccess.getMotherboardAccess().getNameAssignment_1()); 
            // InternalComputerDsl.g:2195:2: ( rule__Motherboard__NameAssignment_1 )
            // InternalComputerDsl.g:2195:3: rule__Motherboard__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Motherboard__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMotherboardAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__1__Impl"


    // $ANTLR start "rule__Motherboard__Group__2"
    // InternalComputerDsl.g:2203:1: rule__Motherboard__Group__2 : rule__Motherboard__Group__2__Impl rule__Motherboard__Group__3 ;
    public final void rule__Motherboard__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2207:1: ( rule__Motherboard__Group__2__Impl rule__Motherboard__Group__3 )
            // InternalComputerDsl.g:2208:2: rule__Motherboard__Group__2__Impl rule__Motherboard__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__Motherboard__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Motherboard__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__2"


    // $ANTLR start "rule__Motherboard__Group__2__Impl"
    // InternalComputerDsl.g:2215:1: rule__Motherboard__Group__2__Impl : ( '{' ) ;
    public final void rule__Motherboard__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2219:1: ( ( '{' ) )
            // InternalComputerDsl.g:2220:1: ( '{' )
            {
            // InternalComputerDsl.g:2220:1: ( '{' )
            // InternalComputerDsl.g:2221:2: '{'
            {
             before(grammarAccess.getMotherboardAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getMotherboardAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__2__Impl"


    // $ANTLR start "rule__Motherboard__Group__3"
    // InternalComputerDsl.g:2230:1: rule__Motherboard__Group__3 : rule__Motherboard__Group__3__Impl rule__Motherboard__Group__4 ;
    public final void rule__Motherboard__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2234:1: ( rule__Motherboard__Group__3__Impl rule__Motherboard__Group__4 )
            // InternalComputerDsl.g:2235:2: rule__Motherboard__Group__3__Impl rule__Motherboard__Group__4
            {
            pushFollow(FOLLOW_19);
            rule__Motherboard__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Motherboard__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__3"


    // $ANTLR start "rule__Motherboard__Group__3__Impl"
    // InternalComputerDsl.g:2242:1: rule__Motherboard__Group__3__Impl : ( 'power' ) ;
    public final void rule__Motherboard__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2246:1: ( ( 'power' ) )
            // InternalComputerDsl.g:2247:1: ( 'power' )
            {
            // InternalComputerDsl.g:2247:1: ( 'power' )
            // InternalComputerDsl.g:2248:2: 'power'
            {
             before(grammarAccess.getMotherboardAccess().getPowerKeyword_3()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getMotherboardAccess().getPowerKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__3__Impl"


    // $ANTLR start "rule__Motherboard__Group__4"
    // InternalComputerDsl.g:2257:1: rule__Motherboard__Group__4 : rule__Motherboard__Group__4__Impl rule__Motherboard__Group__5 ;
    public final void rule__Motherboard__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2261:1: ( rule__Motherboard__Group__4__Impl rule__Motherboard__Group__5 )
            // InternalComputerDsl.g:2262:2: rule__Motherboard__Group__4__Impl rule__Motherboard__Group__5
            {
            pushFollow(FOLLOW_20);
            rule__Motherboard__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Motherboard__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__4"


    // $ANTLR start "rule__Motherboard__Group__4__Impl"
    // InternalComputerDsl.g:2269:1: rule__Motherboard__Group__4__Impl : ( ( rule__Motherboard__PowerAssignment_4 ) ) ;
    public final void rule__Motherboard__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2273:1: ( ( ( rule__Motherboard__PowerAssignment_4 ) ) )
            // InternalComputerDsl.g:2274:1: ( ( rule__Motherboard__PowerAssignment_4 ) )
            {
            // InternalComputerDsl.g:2274:1: ( ( rule__Motherboard__PowerAssignment_4 ) )
            // InternalComputerDsl.g:2275:2: ( rule__Motherboard__PowerAssignment_4 )
            {
             before(grammarAccess.getMotherboardAccess().getPowerAssignment_4()); 
            // InternalComputerDsl.g:2276:2: ( rule__Motherboard__PowerAssignment_4 )
            // InternalComputerDsl.g:2276:3: rule__Motherboard__PowerAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Motherboard__PowerAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getMotherboardAccess().getPowerAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__4__Impl"


    // $ANTLR start "rule__Motherboard__Group__5"
    // InternalComputerDsl.g:2284:1: rule__Motherboard__Group__5 : rule__Motherboard__Group__5__Impl rule__Motherboard__Group__6 ;
    public final void rule__Motherboard__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2288:1: ( rule__Motherboard__Group__5__Impl rule__Motherboard__Group__6 )
            // InternalComputerDsl.g:2289:2: rule__Motherboard__Group__5__Impl rule__Motherboard__Group__6
            {
            pushFollow(FOLLOW_21);
            rule__Motherboard__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Motherboard__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__5"


    // $ANTLR start "rule__Motherboard__Group__5__Impl"
    // InternalComputerDsl.g:2296:1: rule__Motherboard__Group__5__Impl : ( 'type' ) ;
    public final void rule__Motherboard__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2300:1: ( ( 'type' ) )
            // InternalComputerDsl.g:2301:1: ( 'type' )
            {
            // InternalComputerDsl.g:2301:1: ( 'type' )
            // InternalComputerDsl.g:2302:2: 'type'
            {
             before(grammarAccess.getMotherboardAccess().getTypeKeyword_5()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getMotherboardAccess().getTypeKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__5__Impl"


    // $ANTLR start "rule__Motherboard__Group__6"
    // InternalComputerDsl.g:2311:1: rule__Motherboard__Group__6 : rule__Motherboard__Group__6__Impl rule__Motherboard__Group__7 ;
    public final void rule__Motherboard__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2315:1: ( rule__Motherboard__Group__6__Impl rule__Motherboard__Group__7 )
            // InternalComputerDsl.g:2316:2: rule__Motherboard__Group__6__Impl rule__Motherboard__Group__7
            {
            pushFollow(FOLLOW_22);
            rule__Motherboard__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Motherboard__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__6"


    // $ANTLR start "rule__Motherboard__Group__6__Impl"
    // InternalComputerDsl.g:2323:1: rule__Motherboard__Group__6__Impl : ( ( rule__Motherboard__TypeAssignment_6 ) ) ;
    public final void rule__Motherboard__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2327:1: ( ( ( rule__Motherboard__TypeAssignment_6 ) ) )
            // InternalComputerDsl.g:2328:1: ( ( rule__Motherboard__TypeAssignment_6 ) )
            {
            // InternalComputerDsl.g:2328:1: ( ( rule__Motherboard__TypeAssignment_6 ) )
            // InternalComputerDsl.g:2329:2: ( rule__Motherboard__TypeAssignment_6 )
            {
             before(grammarAccess.getMotherboardAccess().getTypeAssignment_6()); 
            // InternalComputerDsl.g:2330:2: ( rule__Motherboard__TypeAssignment_6 )
            // InternalComputerDsl.g:2330:3: rule__Motherboard__TypeAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Motherboard__TypeAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getMotherboardAccess().getTypeAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__6__Impl"


    // $ANTLR start "rule__Motherboard__Group__7"
    // InternalComputerDsl.g:2338:1: rule__Motherboard__Group__7 : rule__Motherboard__Group__7__Impl rule__Motherboard__Group__8 ;
    public final void rule__Motherboard__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2342:1: ( rule__Motherboard__Group__7__Impl rule__Motherboard__Group__8 )
            // InternalComputerDsl.g:2343:2: rule__Motherboard__Group__7__Impl rule__Motherboard__Group__8
            {
            pushFollow(FOLLOW_23);
            rule__Motherboard__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Motherboard__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__7"


    // $ANTLR start "rule__Motherboard__Group__7__Impl"
    // InternalComputerDsl.g:2350:1: rule__Motherboard__Group__7__Impl : ( 'chipset' ) ;
    public final void rule__Motherboard__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2354:1: ( ( 'chipset' ) )
            // InternalComputerDsl.g:2355:1: ( 'chipset' )
            {
            // InternalComputerDsl.g:2355:1: ( 'chipset' )
            // InternalComputerDsl.g:2356:2: 'chipset'
            {
             before(grammarAccess.getMotherboardAccess().getChipsetKeyword_7()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getMotherboardAccess().getChipsetKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__7__Impl"


    // $ANTLR start "rule__Motherboard__Group__8"
    // InternalComputerDsl.g:2365:1: rule__Motherboard__Group__8 : rule__Motherboard__Group__8__Impl rule__Motherboard__Group__9 ;
    public final void rule__Motherboard__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2369:1: ( rule__Motherboard__Group__8__Impl rule__Motherboard__Group__9 )
            // InternalComputerDsl.g:2370:2: rule__Motherboard__Group__8__Impl rule__Motherboard__Group__9
            {
            pushFollow(FOLLOW_24);
            rule__Motherboard__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Motherboard__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__8"


    // $ANTLR start "rule__Motherboard__Group__8__Impl"
    // InternalComputerDsl.g:2377:1: rule__Motherboard__Group__8__Impl : ( ( rule__Motherboard__ChipsetAssignment_8 ) ) ;
    public final void rule__Motherboard__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2381:1: ( ( ( rule__Motherboard__ChipsetAssignment_8 ) ) )
            // InternalComputerDsl.g:2382:1: ( ( rule__Motherboard__ChipsetAssignment_8 ) )
            {
            // InternalComputerDsl.g:2382:1: ( ( rule__Motherboard__ChipsetAssignment_8 ) )
            // InternalComputerDsl.g:2383:2: ( rule__Motherboard__ChipsetAssignment_8 )
            {
             before(grammarAccess.getMotherboardAccess().getChipsetAssignment_8()); 
            // InternalComputerDsl.g:2384:2: ( rule__Motherboard__ChipsetAssignment_8 )
            // InternalComputerDsl.g:2384:3: rule__Motherboard__ChipsetAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Motherboard__ChipsetAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getMotherboardAccess().getChipsetAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__8__Impl"


    // $ANTLR start "rule__Motherboard__Group__9"
    // InternalComputerDsl.g:2392:1: rule__Motherboard__Group__9 : rule__Motherboard__Group__9__Impl rule__Motherboard__Group__10 ;
    public final void rule__Motherboard__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2396:1: ( rule__Motherboard__Group__9__Impl rule__Motherboard__Group__10 )
            // InternalComputerDsl.g:2397:2: rule__Motherboard__Group__9__Impl rule__Motherboard__Group__10
            {
            pushFollow(FOLLOW_25);
            rule__Motherboard__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Motherboard__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__9"


    // $ANTLR start "rule__Motherboard__Group__9__Impl"
    // InternalComputerDsl.g:2404:1: rule__Motherboard__Group__9__Impl : ( 'socket' ) ;
    public final void rule__Motherboard__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2408:1: ( ( 'socket' ) )
            // InternalComputerDsl.g:2409:1: ( 'socket' )
            {
            // InternalComputerDsl.g:2409:1: ( 'socket' )
            // InternalComputerDsl.g:2410:2: 'socket'
            {
             before(grammarAccess.getMotherboardAccess().getSocketKeyword_9()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getMotherboardAccess().getSocketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__9__Impl"


    // $ANTLR start "rule__Motherboard__Group__10"
    // InternalComputerDsl.g:2419:1: rule__Motherboard__Group__10 : rule__Motherboard__Group__10__Impl rule__Motherboard__Group__11 ;
    public final void rule__Motherboard__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2423:1: ( rule__Motherboard__Group__10__Impl rule__Motherboard__Group__11 )
            // InternalComputerDsl.g:2424:2: rule__Motherboard__Group__10__Impl rule__Motherboard__Group__11
            {
            pushFollow(FOLLOW_26);
            rule__Motherboard__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Motherboard__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__10"


    // $ANTLR start "rule__Motherboard__Group__10__Impl"
    // InternalComputerDsl.g:2431:1: rule__Motherboard__Group__10__Impl : ( ( rule__Motherboard__SocketAssignment_10 ) ) ;
    public final void rule__Motherboard__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2435:1: ( ( ( rule__Motherboard__SocketAssignment_10 ) ) )
            // InternalComputerDsl.g:2436:1: ( ( rule__Motherboard__SocketAssignment_10 ) )
            {
            // InternalComputerDsl.g:2436:1: ( ( rule__Motherboard__SocketAssignment_10 ) )
            // InternalComputerDsl.g:2437:2: ( rule__Motherboard__SocketAssignment_10 )
            {
             before(grammarAccess.getMotherboardAccess().getSocketAssignment_10()); 
            // InternalComputerDsl.g:2438:2: ( rule__Motherboard__SocketAssignment_10 )
            // InternalComputerDsl.g:2438:3: rule__Motherboard__SocketAssignment_10
            {
            pushFollow(FOLLOW_2);
            rule__Motherboard__SocketAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getMotherboardAccess().getSocketAssignment_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__10__Impl"


    // $ANTLR start "rule__Motherboard__Group__11"
    // InternalComputerDsl.g:2446:1: rule__Motherboard__Group__11 : rule__Motherboard__Group__11__Impl rule__Motherboard__Group__12 ;
    public final void rule__Motherboard__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2450:1: ( rule__Motherboard__Group__11__Impl rule__Motherboard__Group__12 )
            // InternalComputerDsl.g:2451:2: rule__Motherboard__Group__11__Impl rule__Motherboard__Group__12
            {
            pushFollow(FOLLOW_26);
            rule__Motherboard__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Motherboard__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__11"


    // $ANTLR start "rule__Motherboard__Group__11__Impl"
    // InternalComputerDsl.g:2458:1: rule__Motherboard__Group__11__Impl : ( ( rule__Motherboard__Group_11__0 )? ) ;
    public final void rule__Motherboard__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2462:1: ( ( ( rule__Motherboard__Group_11__0 )? ) )
            // InternalComputerDsl.g:2463:1: ( ( rule__Motherboard__Group_11__0 )? )
            {
            // InternalComputerDsl.g:2463:1: ( ( rule__Motherboard__Group_11__0 )? )
            // InternalComputerDsl.g:2464:2: ( rule__Motherboard__Group_11__0 )?
            {
             before(grammarAccess.getMotherboardAccess().getGroup_11()); 
            // InternalComputerDsl.g:2465:2: ( rule__Motherboard__Group_11__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==63) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalComputerDsl.g:2465:3: rule__Motherboard__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Motherboard__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMotherboardAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__11__Impl"


    // $ANTLR start "rule__Motherboard__Group__12"
    // InternalComputerDsl.g:2473:1: rule__Motherboard__Group__12 : rule__Motherboard__Group__12__Impl ;
    public final void rule__Motherboard__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2477:1: ( rule__Motherboard__Group__12__Impl )
            // InternalComputerDsl.g:2478:2: rule__Motherboard__Group__12__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Motherboard__Group__12__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__12"


    // $ANTLR start "rule__Motherboard__Group__12__Impl"
    // InternalComputerDsl.g:2484:1: rule__Motherboard__Group__12__Impl : ( '}' ) ;
    public final void rule__Motherboard__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2488:1: ( ( '}' ) )
            // InternalComputerDsl.g:2489:1: ( '}' )
            {
            // InternalComputerDsl.g:2489:1: ( '}' )
            // InternalComputerDsl.g:2490:2: '}'
            {
             before(grammarAccess.getMotherboardAccess().getRightCurlyBracketKeyword_12()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getMotherboardAccess().getRightCurlyBracketKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group__12__Impl"


    // $ANTLR start "rule__Motherboard__Group_11__0"
    // InternalComputerDsl.g:2500:1: rule__Motherboard__Group_11__0 : rule__Motherboard__Group_11__0__Impl rule__Motherboard__Group_11__1 ;
    public final void rule__Motherboard__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2504:1: ( rule__Motherboard__Group_11__0__Impl rule__Motherboard__Group_11__1 )
            // InternalComputerDsl.g:2505:2: rule__Motherboard__Group_11__0__Impl rule__Motherboard__Group_11__1
            {
            pushFollow(FOLLOW_27);
            rule__Motherboard__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Motherboard__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group_11__0"


    // $ANTLR start "rule__Motherboard__Group_11__0__Impl"
    // InternalComputerDsl.g:2512:1: rule__Motherboard__Group_11__0__Impl : ( 'ports' ) ;
    public final void rule__Motherboard__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2516:1: ( ( 'ports' ) )
            // InternalComputerDsl.g:2517:1: ( 'ports' )
            {
            // InternalComputerDsl.g:2517:1: ( 'ports' )
            // InternalComputerDsl.g:2518:2: 'ports'
            {
             before(grammarAccess.getMotherboardAccess().getPortsKeyword_11_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getMotherboardAccess().getPortsKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group_11__0__Impl"


    // $ANTLR start "rule__Motherboard__Group_11__1"
    // InternalComputerDsl.g:2527:1: rule__Motherboard__Group_11__1 : rule__Motherboard__Group_11__1__Impl rule__Motherboard__Group_11__2 ;
    public final void rule__Motherboard__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2531:1: ( rule__Motherboard__Group_11__1__Impl rule__Motherboard__Group_11__2 )
            // InternalComputerDsl.g:2532:2: rule__Motherboard__Group_11__1__Impl rule__Motherboard__Group_11__2
            {
            pushFollow(FOLLOW_17);
            rule__Motherboard__Group_11__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Motherboard__Group_11__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group_11__1"


    // $ANTLR start "rule__Motherboard__Group_11__1__Impl"
    // InternalComputerDsl.g:2539:1: rule__Motherboard__Group_11__1__Impl : ( ( rule__Motherboard__PortsAssignment_11_1 ) ) ;
    public final void rule__Motherboard__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2543:1: ( ( ( rule__Motherboard__PortsAssignment_11_1 ) ) )
            // InternalComputerDsl.g:2544:1: ( ( rule__Motherboard__PortsAssignment_11_1 ) )
            {
            // InternalComputerDsl.g:2544:1: ( ( rule__Motherboard__PortsAssignment_11_1 ) )
            // InternalComputerDsl.g:2545:2: ( rule__Motherboard__PortsAssignment_11_1 )
            {
             before(grammarAccess.getMotherboardAccess().getPortsAssignment_11_1()); 
            // InternalComputerDsl.g:2546:2: ( rule__Motherboard__PortsAssignment_11_1 )
            // InternalComputerDsl.g:2546:3: rule__Motherboard__PortsAssignment_11_1
            {
            pushFollow(FOLLOW_2);
            rule__Motherboard__PortsAssignment_11_1();

            state._fsp--;


            }

             after(grammarAccess.getMotherboardAccess().getPortsAssignment_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group_11__1__Impl"


    // $ANTLR start "rule__Motherboard__Group_11__2"
    // InternalComputerDsl.g:2554:1: rule__Motherboard__Group_11__2 : rule__Motherboard__Group_11__2__Impl ;
    public final void rule__Motherboard__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2558:1: ( rule__Motherboard__Group_11__2__Impl )
            // InternalComputerDsl.g:2559:2: rule__Motherboard__Group_11__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Motherboard__Group_11__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group_11__2"


    // $ANTLR start "rule__Motherboard__Group_11__2__Impl"
    // InternalComputerDsl.g:2565:1: rule__Motherboard__Group_11__2__Impl : ( ( rule__Motherboard__Group_11_2__0 )* ) ;
    public final void rule__Motherboard__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2569:1: ( ( ( rule__Motherboard__Group_11_2__0 )* ) )
            // InternalComputerDsl.g:2570:1: ( ( rule__Motherboard__Group_11_2__0 )* )
            {
            // InternalComputerDsl.g:2570:1: ( ( rule__Motherboard__Group_11_2__0 )* )
            // InternalComputerDsl.g:2571:2: ( rule__Motherboard__Group_11_2__0 )*
            {
             before(grammarAccess.getMotherboardAccess().getGroup_11_2()); 
            // InternalComputerDsl.g:2572:2: ( rule__Motherboard__Group_11_2__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==56) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalComputerDsl.g:2572:3: rule__Motherboard__Group_11_2__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__Motherboard__Group_11_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getMotherboardAccess().getGroup_11_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group_11__2__Impl"


    // $ANTLR start "rule__Motherboard__Group_11_2__0"
    // InternalComputerDsl.g:2581:1: rule__Motherboard__Group_11_2__0 : rule__Motherboard__Group_11_2__0__Impl rule__Motherboard__Group_11_2__1 ;
    public final void rule__Motherboard__Group_11_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2585:1: ( rule__Motherboard__Group_11_2__0__Impl rule__Motherboard__Group_11_2__1 )
            // InternalComputerDsl.g:2586:2: rule__Motherboard__Group_11_2__0__Impl rule__Motherboard__Group_11_2__1
            {
            pushFollow(FOLLOW_27);
            rule__Motherboard__Group_11_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Motherboard__Group_11_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group_11_2__0"


    // $ANTLR start "rule__Motherboard__Group_11_2__0__Impl"
    // InternalComputerDsl.g:2593:1: rule__Motherboard__Group_11_2__0__Impl : ( ',' ) ;
    public final void rule__Motherboard__Group_11_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2597:1: ( ( ',' ) )
            // InternalComputerDsl.g:2598:1: ( ',' )
            {
            // InternalComputerDsl.g:2598:1: ( ',' )
            // InternalComputerDsl.g:2599:2: ','
            {
             before(grammarAccess.getMotherboardAccess().getCommaKeyword_11_2_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getMotherboardAccess().getCommaKeyword_11_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group_11_2__0__Impl"


    // $ANTLR start "rule__Motherboard__Group_11_2__1"
    // InternalComputerDsl.g:2608:1: rule__Motherboard__Group_11_2__1 : rule__Motherboard__Group_11_2__1__Impl ;
    public final void rule__Motherboard__Group_11_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2612:1: ( rule__Motherboard__Group_11_2__1__Impl )
            // InternalComputerDsl.g:2613:2: rule__Motherboard__Group_11_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Motherboard__Group_11_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group_11_2__1"


    // $ANTLR start "rule__Motherboard__Group_11_2__1__Impl"
    // InternalComputerDsl.g:2619:1: rule__Motherboard__Group_11_2__1__Impl : ( ( rule__Motherboard__PortsAssignment_11_2_1 ) ) ;
    public final void rule__Motherboard__Group_11_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2623:1: ( ( ( rule__Motherboard__PortsAssignment_11_2_1 ) ) )
            // InternalComputerDsl.g:2624:1: ( ( rule__Motherboard__PortsAssignment_11_2_1 ) )
            {
            // InternalComputerDsl.g:2624:1: ( ( rule__Motherboard__PortsAssignment_11_2_1 ) )
            // InternalComputerDsl.g:2625:2: ( rule__Motherboard__PortsAssignment_11_2_1 )
            {
             before(grammarAccess.getMotherboardAccess().getPortsAssignment_11_2_1()); 
            // InternalComputerDsl.g:2626:2: ( rule__Motherboard__PortsAssignment_11_2_1 )
            // InternalComputerDsl.g:2626:3: rule__Motherboard__PortsAssignment_11_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Motherboard__PortsAssignment_11_2_1();

            state._fsp--;


            }

             after(grammarAccess.getMotherboardAccess().getPortsAssignment_11_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__Group_11_2__1__Impl"


    // $ANTLR start "rule__Processor__Group__0"
    // InternalComputerDsl.g:2635:1: rule__Processor__Group__0 : rule__Processor__Group__0__Impl rule__Processor__Group__1 ;
    public final void rule__Processor__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2639:1: ( rule__Processor__Group__0__Impl rule__Processor__Group__1 )
            // InternalComputerDsl.g:2640:2: rule__Processor__Group__0__Impl rule__Processor__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Processor__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Processor__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__0"


    // $ANTLR start "rule__Processor__Group__0__Impl"
    // InternalComputerDsl.g:2647:1: rule__Processor__Group__0__Impl : ( 'processor' ) ;
    public final void rule__Processor__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2651:1: ( ( 'processor' ) )
            // InternalComputerDsl.g:2652:1: ( 'processor' )
            {
            // InternalComputerDsl.g:2652:1: ( 'processor' )
            // InternalComputerDsl.g:2653:2: 'processor'
            {
             before(grammarAccess.getProcessorAccess().getProcessorKeyword_0()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getProcessorAccess().getProcessorKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__0__Impl"


    // $ANTLR start "rule__Processor__Group__1"
    // InternalComputerDsl.g:2662:1: rule__Processor__Group__1 : rule__Processor__Group__1__Impl rule__Processor__Group__2 ;
    public final void rule__Processor__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2666:1: ( rule__Processor__Group__1__Impl rule__Processor__Group__2 )
            // InternalComputerDsl.g:2667:2: rule__Processor__Group__1__Impl rule__Processor__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Processor__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Processor__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__1"


    // $ANTLR start "rule__Processor__Group__1__Impl"
    // InternalComputerDsl.g:2674:1: rule__Processor__Group__1__Impl : ( ( rule__Processor__NameAssignment_1 ) ) ;
    public final void rule__Processor__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2678:1: ( ( ( rule__Processor__NameAssignment_1 ) ) )
            // InternalComputerDsl.g:2679:1: ( ( rule__Processor__NameAssignment_1 ) )
            {
            // InternalComputerDsl.g:2679:1: ( ( rule__Processor__NameAssignment_1 ) )
            // InternalComputerDsl.g:2680:2: ( rule__Processor__NameAssignment_1 )
            {
             before(grammarAccess.getProcessorAccess().getNameAssignment_1()); 
            // InternalComputerDsl.g:2681:2: ( rule__Processor__NameAssignment_1 )
            // InternalComputerDsl.g:2681:3: rule__Processor__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Processor__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getProcessorAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__1__Impl"


    // $ANTLR start "rule__Processor__Group__2"
    // InternalComputerDsl.g:2689:1: rule__Processor__Group__2 : rule__Processor__Group__2__Impl rule__Processor__Group__3 ;
    public final void rule__Processor__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2693:1: ( rule__Processor__Group__2__Impl rule__Processor__Group__3 )
            // InternalComputerDsl.g:2694:2: rule__Processor__Group__2__Impl rule__Processor__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__Processor__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Processor__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__2"


    // $ANTLR start "rule__Processor__Group__2__Impl"
    // InternalComputerDsl.g:2701:1: rule__Processor__Group__2__Impl : ( '{' ) ;
    public final void rule__Processor__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2705:1: ( ( '{' ) )
            // InternalComputerDsl.g:2706:1: ( '{' )
            {
            // InternalComputerDsl.g:2706:1: ( '{' )
            // InternalComputerDsl.g:2707:2: '{'
            {
             before(grammarAccess.getProcessorAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getProcessorAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__2__Impl"


    // $ANTLR start "rule__Processor__Group__3"
    // InternalComputerDsl.g:2716:1: rule__Processor__Group__3 : rule__Processor__Group__3__Impl rule__Processor__Group__4 ;
    public final void rule__Processor__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2720:1: ( rule__Processor__Group__3__Impl rule__Processor__Group__4 )
            // InternalComputerDsl.g:2721:2: rule__Processor__Group__3__Impl rule__Processor__Group__4
            {
            pushFollow(FOLLOW_19);
            rule__Processor__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Processor__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__3"


    // $ANTLR start "rule__Processor__Group__3__Impl"
    // InternalComputerDsl.g:2728:1: rule__Processor__Group__3__Impl : ( 'power' ) ;
    public final void rule__Processor__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2732:1: ( ( 'power' ) )
            // InternalComputerDsl.g:2733:1: ( 'power' )
            {
            // InternalComputerDsl.g:2733:1: ( 'power' )
            // InternalComputerDsl.g:2734:2: 'power'
            {
             before(grammarAccess.getProcessorAccess().getPowerKeyword_3()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getProcessorAccess().getPowerKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__3__Impl"


    // $ANTLR start "rule__Processor__Group__4"
    // InternalComputerDsl.g:2743:1: rule__Processor__Group__4 : rule__Processor__Group__4__Impl rule__Processor__Group__5 ;
    public final void rule__Processor__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2747:1: ( rule__Processor__Group__4__Impl rule__Processor__Group__5 )
            // InternalComputerDsl.g:2748:2: rule__Processor__Group__4__Impl rule__Processor__Group__5
            {
            pushFollow(FOLLOW_28);
            rule__Processor__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Processor__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__4"


    // $ANTLR start "rule__Processor__Group__4__Impl"
    // InternalComputerDsl.g:2755:1: rule__Processor__Group__4__Impl : ( ( rule__Processor__PowerAssignment_4 ) ) ;
    public final void rule__Processor__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2759:1: ( ( ( rule__Processor__PowerAssignment_4 ) ) )
            // InternalComputerDsl.g:2760:1: ( ( rule__Processor__PowerAssignment_4 ) )
            {
            // InternalComputerDsl.g:2760:1: ( ( rule__Processor__PowerAssignment_4 ) )
            // InternalComputerDsl.g:2761:2: ( rule__Processor__PowerAssignment_4 )
            {
             before(grammarAccess.getProcessorAccess().getPowerAssignment_4()); 
            // InternalComputerDsl.g:2762:2: ( rule__Processor__PowerAssignment_4 )
            // InternalComputerDsl.g:2762:3: rule__Processor__PowerAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Processor__PowerAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getProcessorAccess().getPowerAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__4__Impl"


    // $ANTLR start "rule__Processor__Group__5"
    // InternalComputerDsl.g:2770:1: rule__Processor__Group__5 : rule__Processor__Group__5__Impl rule__Processor__Group__6 ;
    public final void rule__Processor__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2774:1: ( rule__Processor__Group__5__Impl rule__Processor__Group__6 )
            // InternalComputerDsl.g:2775:2: rule__Processor__Group__5__Impl rule__Processor__Group__6
            {
            pushFollow(FOLLOW_28);
            rule__Processor__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Processor__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__5"


    // $ANTLR start "rule__Processor__Group__5__Impl"
    // InternalComputerDsl.g:2782:1: rule__Processor__Group__5__Impl : ( ( rule__Processor__Group_5__0 )? ) ;
    public final void rule__Processor__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2786:1: ( ( ( rule__Processor__Group_5__0 )? ) )
            // InternalComputerDsl.g:2787:1: ( ( rule__Processor__Group_5__0 )? )
            {
            // InternalComputerDsl.g:2787:1: ( ( rule__Processor__Group_5__0 )? )
            // InternalComputerDsl.g:2788:2: ( rule__Processor__Group_5__0 )?
            {
             before(grammarAccess.getProcessorAccess().getGroup_5()); 
            // InternalComputerDsl.g:2789:2: ( rule__Processor__Group_5__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==65) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalComputerDsl.g:2789:3: rule__Processor__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Processor__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getProcessorAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__5__Impl"


    // $ANTLR start "rule__Processor__Group__6"
    // InternalComputerDsl.g:2797:1: rule__Processor__Group__6 : rule__Processor__Group__6__Impl rule__Processor__Group__7 ;
    public final void rule__Processor__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2801:1: ( rule__Processor__Group__6__Impl rule__Processor__Group__7 )
            // InternalComputerDsl.g:2802:2: rule__Processor__Group__6__Impl rule__Processor__Group__7
            {
            pushFollow(FOLLOW_25);
            rule__Processor__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Processor__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__6"


    // $ANTLR start "rule__Processor__Group__6__Impl"
    // InternalComputerDsl.g:2809:1: rule__Processor__Group__6__Impl : ( 'socket' ) ;
    public final void rule__Processor__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2813:1: ( ( 'socket' ) )
            // InternalComputerDsl.g:2814:1: ( 'socket' )
            {
            // InternalComputerDsl.g:2814:1: ( 'socket' )
            // InternalComputerDsl.g:2815:2: 'socket'
            {
             before(grammarAccess.getProcessorAccess().getSocketKeyword_6()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getProcessorAccess().getSocketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__6__Impl"


    // $ANTLR start "rule__Processor__Group__7"
    // InternalComputerDsl.g:2824:1: rule__Processor__Group__7 : rule__Processor__Group__7__Impl rule__Processor__Group__8 ;
    public final void rule__Processor__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2828:1: ( rule__Processor__Group__7__Impl rule__Processor__Group__8 )
            // InternalComputerDsl.g:2829:2: rule__Processor__Group__7__Impl rule__Processor__Group__8
            {
            pushFollow(FOLLOW_29);
            rule__Processor__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Processor__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__7"


    // $ANTLR start "rule__Processor__Group__7__Impl"
    // InternalComputerDsl.g:2836:1: rule__Processor__Group__7__Impl : ( ( rule__Processor__SocketAssignment_7 ) ) ;
    public final void rule__Processor__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2840:1: ( ( ( rule__Processor__SocketAssignment_7 ) ) )
            // InternalComputerDsl.g:2841:1: ( ( rule__Processor__SocketAssignment_7 ) )
            {
            // InternalComputerDsl.g:2841:1: ( ( rule__Processor__SocketAssignment_7 ) )
            // InternalComputerDsl.g:2842:2: ( rule__Processor__SocketAssignment_7 )
            {
             before(grammarAccess.getProcessorAccess().getSocketAssignment_7()); 
            // InternalComputerDsl.g:2843:2: ( rule__Processor__SocketAssignment_7 )
            // InternalComputerDsl.g:2843:3: rule__Processor__SocketAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Processor__SocketAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getProcessorAccess().getSocketAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__7__Impl"


    // $ANTLR start "rule__Processor__Group__8"
    // InternalComputerDsl.g:2851:1: rule__Processor__Group__8 : rule__Processor__Group__8__Impl rule__Processor__Group__9 ;
    public final void rule__Processor__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2855:1: ( rule__Processor__Group__8__Impl rule__Processor__Group__9 )
            // InternalComputerDsl.g:2856:2: rule__Processor__Group__8__Impl rule__Processor__Group__9
            {
            pushFollow(FOLLOW_19);
            rule__Processor__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Processor__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__8"


    // $ANTLR start "rule__Processor__Group__8__Impl"
    // InternalComputerDsl.g:2863:1: rule__Processor__Group__8__Impl : ( 'cores' ) ;
    public final void rule__Processor__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2867:1: ( ( 'cores' ) )
            // InternalComputerDsl.g:2868:1: ( 'cores' )
            {
            // InternalComputerDsl.g:2868:1: ( 'cores' )
            // InternalComputerDsl.g:2869:2: 'cores'
            {
             before(grammarAccess.getProcessorAccess().getCoresKeyword_8()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getProcessorAccess().getCoresKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__8__Impl"


    // $ANTLR start "rule__Processor__Group__9"
    // InternalComputerDsl.g:2878:1: rule__Processor__Group__9 : rule__Processor__Group__9__Impl rule__Processor__Group__10 ;
    public final void rule__Processor__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2882:1: ( rule__Processor__Group__9__Impl rule__Processor__Group__10 )
            // InternalComputerDsl.g:2883:2: rule__Processor__Group__9__Impl rule__Processor__Group__10
            {
            pushFollow(FOLLOW_16);
            rule__Processor__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Processor__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__9"


    // $ANTLR start "rule__Processor__Group__9__Impl"
    // InternalComputerDsl.g:2890:1: rule__Processor__Group__9__Impl : ( ( rule__Processor__CoresAssignment_9 ) ) ;
    public final void rule__Processor__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2894:1: ( ( ( rule__Processor__CoresAssignment_9 ) ) )
            // InternalComputerDsl.g:2895:1: ( ( rule__Processor__CoresAssignment_9 ) )
            {
            // InternalComputerDsl.g:2895:1: ( ( rule__Processor__CoresAssignment_9 ) )
            // InternalComputerDsl.g:2896:2: ( rule__Processor__CoresAssignment_9 )
            {
             before(grammarAccess.getProcessorAccess().getCoresAssignment_9()); 
            // InternalComputerDsl.g:2897:2: ( rule__Processor__CoresAssignment_9 )
            // InternalComputerDsl.g:2897:3: rule__Processor__CoresAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__Processor__CoresAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getProcessorAccess().getCoresAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__9__Impl"


    // $ANTLR start "rule__Processor__Group__10"
    // InternalComputerDsl.g:2905:1: rule__Processor__Group__10 : rule__Processor__Group__10__Impl ;
    public final void rule__Processor__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2909:1: ( rule__Processor__Group__10__Impl )
            // InternalComputerDsl.g:2910:2: rule__Processor__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Processor__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__10"


    // $ANTLR start "rule__Processor__Group__10__Impl"
    // InternalComputerDsl.g:2916:1: rule__Processor__Group__10__Impl : ( '}' ) ;
    public final void rule__Processor__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2920:1: ( ( '}' ) )
            // InternalComputerDsl.g:2921:1: ( '}' )
            {
            // InternalComputerDsl.g:2921:1: ( '}' )
            // InternalComputerDsl.g:2922:2: '}'
            {
             before(grammarAccess.getProcessorAccess().getRightCurlyBracketKeyword_10()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getProcessorAccess().getRightCurlyBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group__10__Impl"


    // $ANTLR start "rule__Processor__Group_5__0"
    // InternalComputerDsl.g:2932:1: rule__Processor__Group_5__0 : rule__Processor__Group_5__0__Impl rule__Processor__Group_5__1 ;
    public final void rule__Processor__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2936:1: ( rule__Processor__Group_5__0__Impl rule__Processor__Group_5__1 )
            // InternalComputerDsl.g:2937:2: rule__Processor__Group_5__0__Impl rule__Processor__Group_5__1
            {
            pushFollow(FOLLOW_23);
            rule__Processor__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Processor__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group_5__0"


    // $ANTLR start "rule__Processor__Group_5__0__Impl"
    // InternalComputerDsl.g:2944:1: rule__Processor__Group_5__0__Impl : ( 'model' ) ;
    public final void rule__Processor__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2948:1: ( ( 'model' ) )
            // InternalComputerDsl.g:2949:1: ( 'model' )
            {
            // InternalComputerDsl.g:2949:1: ( 'model' )
            // InternalComputerDsl.g:2950:2: 'model'
            {
             before(grammarAccess.getProcessorAccess().getModelKeyword_5_0()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getProcessorAccess().getModelKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group_5__0__Impl"


    // $ANTLR start "rule__Processor__Group_5__1"
    // InternalComputerDsl.g:2959:1: rule__Processor__Group_5__1 : rule__Processor__Group_5__1__Impl ;
    public final void rule__Processor__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2963:1: ( rule__Processor__Group_5__1__Impl )
            // InternalComputerDsl.g:2964:2: rule__Processor__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Processor__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group_5__1"


    // $ANTLR start "rule__Processor__Group_5__1__Impl"
    // InternalComputerDsl.g:2970:1: rule__Processor__Group_5__1__Impl : ( ( rule__Processor__ModelAssignment_5_1 ) ) ;
    public final void rule__Processor__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2974:1: ( ( ( rule__Processor__ModelAssignment_5_1 ) ) )
            // InternalComputerDsl.g:2975:1: ( ( rule__Processor__ModelAssignment_5_1 ) )
            {
            // InternalComputerDsl.g:2975:1: ( ( rule__Processor__ModelAssignment_5_1 ) )
            // InternalComputerDsl.g:2976:2: ( rule__Processor__ModelAssignment_5_1 )
            {
             before(grammarAccess.getProcessorAccess().getModelAssignment_5_1()); 
            // InternalComputerDsl.g:2977:2: ( rule__Processor__ModelAssignment_5_1 )
            // InternalComputerDsl.g:2977:3: rule__Processor__ModelAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Processor__ModelAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getProcessorAccess().getModelAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__Group_5__1__Impl"


    // $ANTLR start "rule__GraphicsCard__Group__0"
    // InternalComputerDsl.g:2986:1: rule__GraphicsCard__Group__0 : rule__GraphicsCard__Group__0__Impl rule__GraphicsCard__Group__1 ;
    public final void rule__GraphicsCard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:2990:1: ( rule__GraphicsCard__Group__0__Impl rule__GraphicsCard__Group__1 )
            // InternalComputerDsl.g:2991:2: rule__GraphicsCard__Group__0__Impl rule__GraphicsCard__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__GraphicsCard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicsCard__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__0"


    // $ANTLR start "rule__GraphicsCard__Group__0__Impl"
    // InternalComputerDsl.g:2998:1: rule__GraphicsCard__Group__0__Impl : ( 'graphics' ) ;
    public final void rule__GraphicsCard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3002:1: ( ( 'graphics' ) )
            // InternalComputerDsl.g:3003:1: ( 'graphics' )
            {
            // InternalComputerDsl.g:3003:1: ( 'graphics' )
            // InternalComputerDsl.g:3004:2: 'graphics'
            {
             before(grammarAccess.getGraphicsCardAccess().getGraphicsKeyword_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getGraphicsCardAccess().getGraphicsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__0__Impl"


    // $ANTLR start "rule__GraphicsCard__Group__1"
    // InternalComputerDsl.g:3013:1: rule__GraphicsCard__Group__1 : rule__GraphicsCard__Group__1__Impl rule__GraphicsCard__Group__2 ;
    public final void rule__GraphicsCard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3017:1: ( rule__GraphicsCard__Group__1__Impl rule__GraphicsCard__Group__2 )
            // InternalComputerDsl.g:3018:2: rule__GraphicsCard__Group__1__Impl rule__GraphicsCard__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__GraphicsCard__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicsCard__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__1"


    // $ANTLR start "rule__GraphicsCard__Group__1__Impl"
    // InternalComputerDsl.g:3025:1: rule__GraphicsCard__Group__1__Impl : ( ( rule__GraphicsCard__NameAssignment_1 ) ) ;
    public final void rule__GraphicsCard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3029:1: ( ( ( rule__GraphicsCard__NameAssignment_1 ) ) )
            // InternalComputerDsl.g:3030:1: ( ( rule__GraphicsCard__NameAssignment_1 ) )
            {
            // InternalComputerDsl.g:3030:1: ( ( rule__GraphicsCard__NameAssignment_1 ) )
            // InternalComputerDsl.g:3031:2: ( rule__GraphicsCard__NameAssignment_1 )
            {
             before(grammarAccess.getGraphicsCardAccess().getNameAssignment_1()); 
            // InternalComputerDsl.g:3032:2: ( rule__GraphicsCard__NameAssignment_1 )
            // InternalComputerDsl.g:3032:3: rule__GraphicsCard__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__GraphicsCard__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getGraphicsCardAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__1__Impl"


    // $ANTLR start "rule__GraphicsCard__Group__2"
    // InternalComputerDsl.g:3040:1: rule__GraphicsCard__Group__2 : rule__GraphicsCard__Group__2__Impl rule__GraphicsCard__Group__3 ;
    public final void rule__GraphicsCard__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3044:1: ( rule__GraphicsCard__Group__2__Impl rule__GraphicsCard__Group__3 )
            // InternalComputerDsl.g:3045:2: rule__GraphicsCard__Group__2__Impl rule__GraphicsCard__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__GraphicsCard__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicsCard__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__2"


    // $ANTLR start "rule__GraphicsCard__Group__2__Impl"
    // InternalComputerDsl.g:3052:1: rule__GraphicsCard__Group__2__Impl : ( '{' ) ;
    public final void rule__GraphicsCard__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3056:1: ( ( '{' ) )
            // InternalComputerDsl.g:3057:1: ( '{' )
            {
            // InternalComputerDsl.g:3057:1: ( '{' )
            // InternalComputerDsl.g:3058:2: '{'
            {
             before(grammarAccess.getGraphicsCardAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getGraphicsCardAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__2__Impl"


    // $ANTLR start "rule__GraphicsCard__Group__3"
    // InternalComputerDsl.g:3067:1: rule__GraphicsCard__Group__3 : rule__GraphicsCard__Group__3__Impl rule__GraphicsCard__Group__4 ;
    public final void rule__GraphicsCard__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3071:1: ( rule__GraphicsCard__Group__3__Impl rule__GraphicsCard__Group__4 )
            // InternalComputerDsl.g:3072:2: rule__GraphicsCard__Group__3__Impl rule__GraphicsCard__Group__4
            {
            pushFollow(FOLLOW_19);
            rule__GraphicsCard__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicsCard__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__3"


    // $ANTLR start "rule__GraphicsCard__Group__3__Impl"
    // InternalComputerDsl.g:3079:1: rule__GraphicsCard__Group__3__Impl : ( 'power' ) ;
    public final void rule__GraphicsCard__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3083:1: ( ( 'power' ) )
            // InternalComputerDsl.g:3084:1: ( 'power' )
            {
            // InternalComputerDsl.g:3084:1: ( 'power' )
            // InternalComputerDsl.g:3085:2: 'power'
            {
             before(grammarAccess.getGraphicsCardAccess().getPowerKeyword_3()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getGraphicsCardAccess().getPowerKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__3__Impl"


    // $ANTLR start "rule__GraphicsCard__Group__4"
    // InternalComputerDsl.g:3094:1: rule__GraphicsCard__Group__4 : rule__GraphicsCard__Group__4__Impl rule__GraphicsCard__Group__5 ;
    public final void rule__GraphicsCard__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3098:1: ( rule__GraphicsCard__Group__4__Impl rule__GraphicsCard__Group__5 )
            // InternalComputerDsl.g:3099:2: rule__GraphicsCard__Group__4__Impl rule__GraphicsCard__Group__5
            {
            pushFollow(FOLLOW_30);
            rule__GraphicsCard__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicsCard__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__4"


    // $ANTLR start "rule__GraphicsCard__Group__4__Impl"
    // InternalComputerDsl.g:3106:1: rule__GraphicsCard__Group__4__Impl : ( ( rule__GraphicsCard__PowerAssignment_4 ) ) ;
    public final void rule__GraphicsCard__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3110:1: ( ( ( rule__GraphicsCard__PowerAssignment_4 ) ) )
            // InternalComputerDsl.g:3111:1: ( ( rule__GraphicsCard__PowerAssignment_4 ) )
            {
            // InternalComputerDsl.g:3111:1: ( ( rule__GraphicsCard__PowerAssignment_4 ) )
            // InternalComputerDsl.g:3112:2: ( rule__GraphicsCard__PowerAssignment_4 )
            {
             before(grammarAccess.getGraphicsCardAccess().getPowerAssignment_4()); 
            // InternalComputerDsl.g:3113:2: ( rule__GraphicsCard__PowerAssignment_4 )
            // InternalComputerDsl.g:3113:3: rule__GraphicsCard__PowerAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__GraphicsCard__PowerAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getGraphicsCardAccess().getPowerAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__4__Impl"


    // $ANTLR start "rule__GraphicsCard__Group__5"
    // InternalComputerDsl.g:3121:1: rule__GraphicsCard__Group__5 : rule__GraphicsCard__Group__5__Impl rule__GraphicsCard__Group__6 ;
    public final void rule__GraphicsCard__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3125:1: ( rule__GraphicsCard__Group__5__Impl rule__GraphicsCard__Group__6 )
            // InternalComputerDsl.g:3126:2: rule__GraphicsCard__Group__5__Impl rule__GraphicsCard__Group__6
            {
            pushFollow(FOLLOW_30);
            rule__GraphicsCard__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicsCard__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__5"


    // $ANTLR start "rule__GraphicsCard__Group__5__Impl"
    // InternalComputerDsl.g:3133:1: rule__GraphicsCard__Group__5__Impl : ( ( rule__GraphicsCard__Group_5__0 )? ) ;
    public final void rule__GraphicsCard__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3137:1: ( ( ( rule__GraphicsCard__Group_5__0 )? ) )
            // InternalComputerDsl.g:3138:1: ( ( rule__GraphicsCard__Group_5__0 )? )
            {
            // InternalComputerDsl.g:3138:1: ( ( rule__GraphicsCard__Group_5__0 )? )
            // InternalComputerDsl.g:3139:2: ( rule__GraphicsCard__Group_5__0 )?
            {
             before(grammarAccess.getGraphicsCardAccess().getGroup_5()); 
            // InternalComputerDsl.g:3140:2: ( rule__GraphicsCard__Group_5__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==65) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalComputerDsl.g:3140:3: rule__GraphicsCard__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__GraphicsCard__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getGraphicsCardAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__5__Impl"


    // $ANTLR start "rule__GraphicsCard__Group__6"
    // InternalComputerDsl.g:3148:1: rule__GraphicsCard__Group__6 : rule__GraphicsCard__Group__6__Impl rule__GraphicsCard__Group__7 ;
    public final void rule__GraphicsCard__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3152:1: ( rule__GraphicsCard__Group__6__Impl rule__GraphicsCard__Group__7 )
            // InternalComputerDsl.g:3153:2: rule__GraphicsCard__Group__6__Impl rule__GraphicsCard__Group__7
            {
            pushFollow(FOLLOW_19);
            rule__GraphicsCard__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicsCard__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__6"


    // $ANTLR start "rule__GraphicsCard__Group__6__Impl"
    // InternalComputerDsl.g:3160:1: rule__GraphicsCard__Group__6__Impl : ( 'vram' ) ;
    public final void rule__GraphicsCard__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3164:1: ( ( 'vram' ) )
            // InternalComputerDsl.g:3165:1: ( 'vram' )
            {
            // InternalComputerDsl.g:3165:1: ( 'vram' )
            // InternalComputerDsl.g:3166:2: 'vram'
            {
             before(grammarAccess.getGraphicsCardAccess().getVramKeyword_6()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getGraphicsCardAccess().getVramKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__6__Impl"


    // $ANTLR start "rule__GraphicsCard__Group__7"
    // InternalComputerDsl.g:3175:1: rule__GraphicsCard__Group__7 : rule__GraphicsCard__Group__7__Impl rule__GraphicsCard__Group__8 ;
    public final void rule__GraphicsCard__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3179:1: ( rule__GraphicsCard__Group__7__Impl rule__GraphicsCard__Group__8 )
            // InternalComputerDsl.g:3180:2: rule__GraphicsCard__Group__7__Impl rule__GraphicsCard__Group__8
            {
            pushFollow(FOLLOW_16);
            rule__GraphicsCard__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicsCard__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__7"


    // $ANTLR start "rule__GraphicsCard__Group__7__Impl"
    // InternalComputerDsl.g:3187:1: rule__GraphicsCard__Group__7__Impl : ( ( rule__GraphicsCard__VramAssignment_7 ) ) ;
    public final void rule__GraphicsCard__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3191:1: ( ( ( rule__GraphicsCard__VramAssignment_7 ) ) )
            // InternalComputerDsl.g:3192:1: ( ( rule__GraphicsCard__VramAssignment_7 ) )
            {
            // InternalComputerDsl.g:3192:1: ( ( rule__GraphicsCard__VramAssignment_7 ) )
            // InternalComputerDsl.g:3193:2: ( rule__GraphicsCard__VramAssignment_7 )
            {
             before(grammarAccess.getGraphicsCardAccess().getVramAssignment_7()); 
            // InternalComputerDsl.g:3194:2: ( rule__GraphicsCard__VramAssignment_7 )
            // InternalComputerDsl.g:3194:3: rule__GraphicsCard__VramAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__GraphicsCard__VramAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getGraphicsCardAccess().getVramAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__7__Impl"


    // $ANTLR start "rule__GraphicsCard__Group__8"
    // InternalComputerDsl.g:3202:1: rule__GraphicsCard__Group__8 : rule__GraphicsCard__Group__8__Impl ;
    public final void rule__GraphicsCard__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3206:1: ( rule__GraphicsCard__Group__8__Impl )
            // InternalComputerDsl.g:3207:2: rule__GraphicsCard__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GraphicsCard__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__8"


    // $ANTLR start "rule__GraphicsCard__Group__8__Impl"
    // InternalComputerDsl.g:3213:1: rule__GraphicsCard__Group__8__Impl : ( '}' ) ;
    public final void rule__GraphicsCard__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3217:1: ( ( '}' ) )
            // InternalComputerDsl.g:3218:1: ( '}' )
            {
            // InternalComputerDsl.g:3218:1: ( '}' )
            // InternalComputerDsl.g:3219:2: '}'
            {
             before(grammarAccess.getGraphicsCardAccess().getRightCurlyBracketKeyword_8()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getGraphicsCardAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group__8__Impl"


    // $ANTLR start "rule__GraphicsCard__Group_5__0"
    // InternalComputerDsl.g:3229:1: rule__GraphicsCard__Group_5__0 : rule__GraphicsCard__Group_5__0__Impl rule__GraphicsCard__Group_5__1 ;
    public final void rule__GraphicsCard__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3233:1: ( rule__GraphicsCard__Group_5__0__Impl rule__GraphicsCard__Group_5__1 )
            // InternalComputerDsl.g:3234:2: rule__GraphicsCard__Group_5__0__Impl rule__GraphicsCard__Group_5__1
            {
            pushFollow(FOLLOW_23);
            rule__GraphicsCard__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__GraphicsCard__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group_5__0"


    // $ANTLR start "rule__GraphicsCard__Group_5__0__Impl"
    // InternalComputerDsl.g:3241:1: rule__GraphicsCard__Group_5__0__Impl : ( 'model' ) ;
    public final void rule__GraphicsCard__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3245:1: ( ( 'model' ) )
            // InternalComputerDsl.g:3246:1: ( 'model' )
            {
            // InternalComputerDsl.g:3246:1: ( 'model' )
            // InternalComputerDsl.g:3247:2: 'model'
            {
             before(grammarAccess.getGraphicsCardAccess().getModelKeyword_5_0()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getGraphicsCardAccess().getModelKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group_5__0__Impl"


    // $ANTLR start "rule__GraphicsCard__Group_5__1"
    // InternalComputerDsl.g:3256:1: rule__GraphicsCard__Group_5__1 : rule__GraphicsCard__Group_5__1__Impl ;
    public final void rule__GraphicsCard__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3260:1: ( rule__GraphicsCard__Group_5__1__Impl )
            // InternalComputerDsl.g:3261:2: rule__GraphicsCard__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__GraphicsCard__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group_5__1"


    // $ANTLR start "rule__GraphicsCard__Group_5__1__Impl"
    // InternalComputerDsl.g:3267:1: rule__GraphicsCard__Group_5__1__Impl : ( ( rule__GraphicsCard__ModelAssignment_5_1 ) ) ;
    public final void rule__GraphicsCard__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3271:1: ( ( ( rule__GraphicsCard__ModelAssignment_5_1 ) ) )
            // InternalComputerDsl.g:3272:1: ( ( rule__GraphicsCard__ModelAssignment_5_1 ) )
            {
            // InternalComputerDsl.g:3272:1: ( ( rule__GraphicsCard__ModelAssignment_5_1 ) )
            // InternalComputerDsl.g:3273:2: ( rule__GraphicsCard__ModelAssignment_5_1 )
            {
             before(grammarAccess.getGraphicsCardAccess().getModelAssignment_5_1()); 
            // InternalComputerDsl.g:3274:2: ( rule__GraphicsCard__ModelAssignment_5_1 )
            // InternalComputerDsl.g:3274:3: rule__GraphicsCard__ModelAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__GraphicsCard__ModelAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getGraphicsCardAccess().getModelAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__Group_5__1__Impl"


    // $ANTLR start "rule__Memory__Group__0"
    // InternalComputerDsl.g:3283:1: rule__Memory__Group__0 : rule__Memory__Group__0__Impl rule__Memory__Group__1 ;
    public final void rule__Memory__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3287:1: ( rule__Memory__Group__0__Impl rule__Memory__Group__1 )
            // InternalComputerDsl.g:3288:2: rule__Memory__Group__0__Impl rule__Memory__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Memory__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Memory__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__0"


    // $ANTLR start "rule__Memory__Group__0__Impl"
    // InternalComputerDsl.g:3295:1: rule__Memory__Group__0__Impl : ( 'memory' ) ;
    public final void rule__Memory__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3299:1: ( ( 'memory' ) )
            // InternalComputerDsl.g:3300:1: ( 'memory' )
            {
            // InternalComputerDsl.g:3300:1: ( 'memory' )
            // InternalComputerDsl.g:3301:2: 'memory'
            {
             before(grammarAccess.getMemoryAccess().getMemoryKeyword_0()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getMemoryAccess().getMemoryKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__0__Impl"


    // $ANTLR start "rule__Memory__Group__1"
    // InternalComputerDsl.g:3310:1: rule__Memory__Group__1 : rule__Memory__Group__1__Impl rule__Memory__Group__2 ;
    public final void rule__Memory__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3314:1: ( rule__Memory__Group__1__Impl rule__Memory__Group__2 )
            // InternalComputerDsl.g:3315:2: rule__Memory__Group__1__Impl rule__Memory__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Memory__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Memory__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__1"


    // $ANTLR start "rule__Memory__Group__1__Impl"
    // InternalComputerDsl.g:3322:1: rule__Memory__Group__1__Impl : ( ( rule__Memory__NameAssignment_1 ) ) ;
    public final void rule__Memory__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3326:1: ( ( ( rule__Memory__NameAssignment_1 ) ) )
            // InternalComputerDsl.g:3327:1: ( ( rule__Memory__NameAssignment_1 ) )
            {
            // InternalComputerDsl.g:3327:1: ( ( rule__Memory__NameAssignment_1 ) )
            // InternalComputerDsl.g:3328:2: ( rule__Memory__NameAssignment_1 )
            {
             before(grammarAccess.getMemoryAccess().getNameAssignment_1()); 
            // InternalComputerDsl.g:3329:2: ( rule__Memory__NameAssignment_1 )
            // InternalComputerDsl.g:3329:3: rule__Memory__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Memory__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMemoryAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__1__Impl"


    // $ANTLR start "rule__Memory__Group__2"
    // InternalComputerDsl.g:3337:1: rule__Memory__Group__2 : rule__Memory__Group__2__Impl rule__Memory__Group__3 ;
    public final void rule__Memory__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3341:1: ( rule__Memory__Group__2__Impl rule__Memory__Group__3 )
            // InternalComputerDsl.g:3342:2: rule__Memory__Group__2__Impl rule__Memory__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__Memory__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Memory__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__2"


    // $ANTLR start "rule__Memory__Group__2__Impl"
    // InternalComputerDsl.g:3349:1: rule__Memory__Group__2__Impl : ( '{' ) ;
    public final void rule__Memory__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3353:1: ( ( '{' ) )
            // InternalComputerDsl.g:3354:1: ( '{' )
            {
            // InternalComputerDsl.g:3354:1: ( '{' )
            // InternalComputerDsl.g:3355:2: '{'
            {
             before(grammarAccess.getMemoryAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getMemoryAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__2__Impl"


    // $ANTLR start "rule__Memory__Group__3"
    // InternalComputerDsl.g:3364:1: rule__Memory__Group__3 : rule__Memory__Group__3__Impl rule__Memory__Group__4 ;
    public final void rule__Memory__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3368:1: ( rule__Memory__Group__3__Impl rule__Memory__Group__4 )
            // InternalComputerDsl.g:3369:2: rule__Memory__Group__3__Impl rule__Memory__Group__4
            {
            pushFollow(FOLLOW_19);
            rule__Memory__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Memory__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__3"


    // $ANTLR start "rule__Memory__Group__3__Impl"
    // InternalComputerDsl.g:3376:1: rule__Memory__Group__3__Impl : ( 'power' ) ;
    public final void rule__Memory__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3380:1: ( ( 'power' ) )
            // InternalComputerDsl.g:3381:1: ( 'power' )
            {
            // InternalComputerDsl.g:3381:1: ( 'power' )
            // InternalComputerDsl.g:3382:2: 'power'
            {
             before(grammarAccess.getMemoryAccess().getPowerKeyword_3()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getMemoryAccess().getPowerKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__3__Impl"


    // $ANTLR start "rule__Memory__Group__4"
    // InternalComputerDsl.g:3391:1: rule__Memory__Group__4 : rule__Memory__Group__4__Impl rule__Memory__Group__5 ;
    public final void rule__Memory__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3395:1: ( rule__Memory__Group__4__Impl rule__Memory__Group__5 )
            // InternalComputerDsl.g:3396:2: rule__Memory__Group__4__Impl rule__Memory__Group__5
            {
            pushFollow(FOLLOW_20);
            rule__Memory__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Memory__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__4"


    // $ANTLR start "rule__Memory__Group__4__Impl"
    // InternalComputerDsl.g:3403:1: rule__Memory__Group__4__Impl : ( ( rule__Memory__PowerAssignment_4 ) ) ;
    public final void rule__Memory__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3407:1: ( ( ( rule__Memory__PowerAssignment_4 ) ) )
            // InternalComputerDsl.g:3408:1: ( ( rule__Memory__PowerAssignment_4 ) )
            {
            // InternalComputerDsl.g:3408:1: ( ( rule__Memory__PowerAssignment_4 ) )
            // InternalComputerDsl.g:3409:2: ( rule__Memory__PowerAssignment_4 )
            {
             before(grammarAccess.getMemoryAccess().getPowerAssignment_4()); 
            // InternalComputerDsl.g:3410:2: ( rule__Memory__PowerAssignment_4 )
            // InternalComputerDsl.g:3410:3: rule__Memory__PowerAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Memory__PowerAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getMemoryAccess().getPowerAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__4__Impl"


    // $ANTLR start "rule__Memory__Group__5"
    // InternalComputerDsl.g:3418:1: rule__Memory__Group__5 : rule__Memory__Group__5__Impl rule__Memory__Group__6 ;
    public final void rule__Memory__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3422:1: ( rule__Memory__Group__5__Impl rule__Memory__Group__6 )
            // InternalComputerDsl.g:3423:2: rule__Memory__Group__5__Impl rule__Memory__Group__6
            {
            pushFollow(FOLLOW_31);
            rule__Memory__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Memory__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__5"


    // $ANTLR start "rule__Memory__Group__5__Impl"
    // InternalComputerDsl.g:3430:1: rule__Memory__Group__5__Impl : ( 'type' ) ;
    public final void rule__Memory__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3434:1: ( ( 'type' ) )
            // InternalComputerDsl.g:3435:1: ( 'type' )
            {
            // InternalComputerDsl.g:3435:1: ( 'type' )
            // InternalComputerDsl.g:3436:2: 'type'
            {
             before(grammarAccess.getMemoryAccess().getTypeKeyword_5()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getMemoryAccess().getTypeKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__5__Impl"


    // $ANTLR start "rule__Memory__Group__6"
    // InternalComputerDsl.g:3445:1: rule__Memory__Group__6 : rule__Memory__Group__6__Impl rule__Memory__Group__7 ;
    public final void rule__Memory__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3449:1: ( rule__Memory__Group__6__Impl rule__Memory__Group__7 )
            // InternalComputerDsl.g:3450:2: rule__Memory__Group__6__Impl rule__Memory__Group__7
            {
            pushFollow(FOLLOW_32);
            rule__Memory__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Memory__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__6"


    // $ANTLR start "rule__Memory__Group__6__Impl"
    // InternalComputerDsl.g:3457:1: rule__Memory__Group__6__Impl : ( ( rule__Memory__TypeAssignment_6 ) ) ;
    public final void rule__Memory__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3461:1: ( ( ( rule__Memory__TypeAssignment_6 ) ) )
            // InternalComputerDsl.g:3462:1: ( ( rule__Memory__TypeAssignment_6 ) )
            {
            // InternalComputerDsl.g:3462:1: ( ( rule__Memory__TypeAssignment_6 ) )
            // InternalComputerDsl.g:3463:2: ( rule__Memory__TypeAssignment_6 )
            {
             before(grammarAccess.getMemoryAccess().getTypeAssignment_6()); 
            // InternalComputerDsl.g:3464:2: ( rule__Memory__TypeAssignment_6 )
            // InternalComputerDsl.g:3464:3: rule__Memory__TypeAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Memory__TypeAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getMemoryAccess().getTypeAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__6__Impl"


    // $ANTLR start "rule__Memory__Group__7"
    // InternalComputerDsl.g:3472:1: rule__Memory__Group__7 : rule__Memory__Group__7__Impl rule__Memory__Group__8 ;
    public final void rule__Memory__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3476:1: ( rule__Memory__Group__7__Impl rule__Memory__Group__8 )
            // InternalComputerDsl.g:3477:2: rule__Memory__Group__7__Impl rule__Memory__Group__8
            {
            pushFollow(FOLLOW_19);
            rule__Memory__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Memory__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__7"


    // $ANTLR start "rule__Memory__Group__7__Impl"
    // InternalComputerDsl.g:3484:1: rule__Memory__Group__7__Impl : ( 'capacity' ) ;
    public final void rule__Memory__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3488:1: ( ( 'capacity' ) )
            // InternalComputerDsl.g:3489:1: ( 'capacity' )
            {
            // InternalComputerDsl.g:3489:1: ( 'capacity' )
            // InternalComputerDsl.g:3490:2: 'capacity'
            {
             before(grammarAccess.getMemoryAccess().getCapacityKeyword_7()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getMemoryAccess().getCapacityKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__7__Impl"


    // $ANTLR start "rule__Memory__Group__8"
    // InternalComputerDsl.g:3499:1: rule__Memory__Group__8 : rule__Memory__Group__8__Impl rule__Memory__Group__9 ;
    public final void rule__Memory__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3503:1: ( rule__Memory__Group__8__Impl rule__Memory__Group__9 )
            // InternalComputerDsl.g:3504:2: rule__Memory__Group__8__Impl rule__Memory__Group__9
            {
            pushFollow(FOLLOW_16);
            rule__Memory__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Memory__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__8"


    // $ANTLR start "rule__Memory__Group__8__Impl"
    // InternalComputerDsl.g:3511:1: rule__Memory__Group__8__Impl : ( ( rule__Memory__CapacityAssignment_8 ) ) ;
    public final void rule__Memory__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3515:1: ( ( ( rule__Memory__CapacityAssignment_8 ) ) )
            // InternalComputerDsl.g:3516:1: ( ( rule__Memory__CapacityAssignment_8 ) )
            {
            // InternalComputerDsl.g:3516:1: ( ( rule__Memory__CapacityAssignment_8 ) )
            // InternalComputerDsl.g:3517:2: ( rule__Memory__CapacityAssignment_8 )
            {
             before(grammarAccess.getMemoryAccess().getCapacityAssignment_8()); 
            // InternalComputerDsl.g:3518:2: ( rule__Memory__CapacityAssignment_8 )
            // InternalComputerDsl.g:3518:3: rule__Memory__CapacityAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Memory__CapacityAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getMemoryAccess().getCapacityAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__8__Impl"


    // $ANTLR start "rule__Memory__Group__9"
    // InternalComputerDsl.g:3526:1: rule__Memory__Group__9 : rule__Memory__Group__9__Impl ;
    public final void rule__Memory__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3530:1: ( rule__Memory__Group__9__Impl )
            // InternalComputerDsl.g:3531:2: rule__Memory__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Memory__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__9"


    // $ANTLR start "rule__Memory__Group__9__Impl"
    // InternalComputerDsl.g:3537:1: rule__Memory__Group__9__Impl : ( '}' ) ;
    public final void rule__Memory__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3541:1: ( ( '}' ) )
            // InternalComputerDsl.g:3542:1: ( '}' )
            {
            // InternalComputerDsl.g:3542:1: ( '}' )
            // InternalComputerDsl.g:3543:2: '}'
            {
             before(grammarAccess.getMemoryAccess().getRightCurlyBracketKeyword_9()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getMemoryAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__Group__9__Impl"


    // $ANTLR start "rule__Storage__Group__0"
    // InternalComputerDsl.g:3553:1: rule__Storage__Group__0 : rule__Storage__Group__0__Impl rule__Storage__Group__1 ;
    public final void rule__Storage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3557:1: ( rule__Storage__Group__0__Impl rule__Storage__Group__1 )
            // InternalComputerDsl.g:3558:2: rule__Storage__Group__0__Impl rule__Storage__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Storage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Storage__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__0"


    // $ANTLR start "rule__Storage__Group__0__Impl"
    // InternalComputerDsl.g:3565:1: rule__Storage__Group__0__Impl : ( 'storage' ) ;
    public final void rule__Storage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3569:1: ( ( 'storage' ) )
            // InternalComputerDsl.g:3570:1: ( 'storage' )
            {
            // InternalComputerDsl.g:3570:1: ( 'storage' )
            // InternalComputerDsl.g:3571:2: 'storage'
            {
             before(grammarAccess.getStorageAccess().getStorageKeyword_0()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getStorageAccess().getStorageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__0__Impl"


    // $ANTLR start "rule__Storage__Group__1"
    // InternalComputerDsl.g:3580:1: rule__Storage__Group__1 : rule__Storage__Group__1__Impl rule__Storage__Group__2 ;
    public final void rule__Storage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3584:1: ( rule__Storage__Group__1__Impl rule__Storage__Group__2 )
            // InternalComputerDsl.g:3585:2: rule__Storage__Group__1__Impl rule__Storage__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Storage__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Storage__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__1"


    // $ANTLR start "rule__Storage__Group__1__Impl"
    // InternalComputerDsl.g:3592:1: rule__Storage__Group__1__Impl : ( ( rule__Storage__NameAssignment_1 ) ) ;
    public final void rule__Storage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3596:1: ( ( ( rule__Storage__NameAssignment_1 ) ) )
            // InternalComputerDsl.g:3597:1: ( ( rule__Storage__NameAssignment_1 ) )
            {
            // InternalComputerDsl.g:3597:1: ( ( rule__Storage__NameAssignment_1 ) )
            // InternalComputerDsl.g:3598:2: ( rule__Storage__NameAssignment_1 )
            {
             before(grammarAccess.getStorageAccess().getNameAssignment_1()); 
            // InternalComputerDsl.g:3599:2: ( rule__Storage__NameAssignment_1 )
            // InternalComputerDsl.g:3599:3: rule__Storage__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Storage__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getStorageAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__1__Impl"


    // $ANTLR start "rule__Storage__Group__2"
    // InternalComputerDsl.g:3607:1: rule__Storage__Group__2 : rule__Storage__Group__2__Impl rule__Storage__Group__3 ;
    public final void rule__Storage__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3611:1: ( rule__Storage__Group__2__Impl rule__Storage__Group__3 )
            // InternalComputerDsl.g:3612:2: rule__Storage__Group__2__Impl rule__Storage__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__Storage__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Storage__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__2"


    // $ANTLR start "rule__Storage__Group__2__Impl"
    // InternalComputerDsl.g:3619:1: rule__Storage__Group__2__Impl : ( '{' ) ;
    public final void rule__Storage__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3623:1: ( ( '{' ) )
            // InternalComputerDsl.g:3624:1: ( '{' )
            {
            // InternalComputerDsl.g:3624:1: ( '{' )
            // InternalComputerDsl.g:3625:2: '{'
            {
             before(grammarAccess.getStorageAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getStorageAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__2__Impl"


    // $ANTLR start "rule__Storage__Group__3"
    // InternalComputerDsl.g:3634:1: rule__Storage__Group__3 : rule__Storage__Group__3__Impl rule__Storage__Group__4 ;
    public final void rule__Storage__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3638:1: ( rule__Storage__Group__3__Impl rule__Storage__Group__4 )
            // InternalComputerDsl.g:3639:2: rule__Storage__Group__3__Impl rule__Storage__Group__4
            {
            pushFollow(FOLLOW_19);
            rule__Storage__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Storage__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__3"


    // $ANTLR start "rule__Storage__Group__3__Impl"
    // InternalComputerDsl.g:3646:1: rule__Storage__Group__3__Impl : ( 'power' ) ;
    public final void rule__Storage__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3650:1: ( ( 'power' ) )
            // InternalComputerDsl.g:3651:1: ( 'power' )
            {
            // InternalComputerDsl.g:3651:1: ( 'power' )
            // InternalComputerDsl.g:3652:2: 'power'
            {
             before(grammarAccess.getStorageAccess().getPowerKeyword_3()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getStorageAccess().getPowerKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__3__Impl"


    // $ANTLR start "rule__Storage__Group__4"
    // InternalComputerDsl.g:3661:1: rule__Storage__Group__4 : rule__Storage__Group__4__Impl rule__Storage__Group__5 ;
    public final void rule__Storage__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3665:1: ( rule__Storage__Group__4__Impl rule__Storage__Group__5 )
            // InternalComputerDsl.g:3666:2: rule__Storage__Group__4__Impl rule__Storage__Group__5
            {
            pushFollow(FOLLOW_20);
            rule__Storage__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Storage__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__4"


    // $ANTLR start "rule__Storage__Group__4__Impl"
    // InternalComputerDsl.g:3673:1: rule__Storage__Group__4__Impl : ( ( rule__Storage__PowerAssignment_4 ) ) ;
    public final void rule__Storage__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3677:1: ( ( ( rule__Storage__PowerAssignment_4 ) ) )
            // InternalComputerDsl.g:3678:1: ( ( rule__Storage__PowerAssignment_4 ) )
            {
            // InternalComputerDsl.g:3678:1: ( ( rule__Storage__PowerAssignment_4 ) )
            // InternalComputerDsl.g:3679:2: ( rule__Storage__PowerAssignment_4 )
            {
             before(grammarAccess.getStorageAccess().getPowerAssignment_4()); 
            // InternalComputerDsl.g:3680:2: ( rule__Storage__PowerAssignment_4 )
            // InternalComputerDsl.g:3680:3: rule__Storage__PowerAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Storage__PowerAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getStorageAccess().getPowerAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__4__Impl"


    // $ANTLR start "rule__Storage__Group__5"
    // InternalComputerDsl.g:3688:1: rule__Storage__Group__5 : rule__Storage__Group__5__Impl rule__Storage__Group__6 ;
    public final void rule__Storage__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3692:1: ( rule__Storage__Group__5__Impl rule__Storage__Group__6 )
            // InternalComputerDsl.g:3693:2: rule__Storage__Group__5__Impl rule__Storage__Group__6
            {
            pushFollow(FOLLOW_33);
            rule__Storage__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Storage__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__5"


    // $ANTLR start "rule__Storage__Group__5__Impl"
    // InternalComputerDsl.g:3700:1: rule__Storage__Group__5__Impl : ( 'type' ) ;
    public final void rule__Storage__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3704:1: ( ( 'type' ) )
            // InternalComputerDsl.g:3705:1: ( 'type' )
            {
            // InternalComputerDsl.g:3705:1: ( 'type' )
            // InternalComputerDsl.g:3706:2: 'type'
            {
             before(grammarAccess.getStorageAccess().getTypeKeyword_5()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getStorageAccess().getTypeKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__5__Impl"


    // $ANTLR start "rule__Storage__Group__6"
    // InternalComputerDsl.g:3715:1: rule__Storage__Group__6 : rule__Storage__Group__6__Impl rule__Storage__Group__7 ;
    public final void rule__Storage__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3719:1: ( rule__Storage__Group__6__Impl rule__Storage__Group__7 )
            // InternalComputerDsl.g:3720:2: rule__Storage__Group__6__Impl rule__Storage__Group__7
            {
            pushFollow(FOLLOW_32);
            rule__Storage__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Storage__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__6"


    // $ANTLR start "rule__Storage__Group__6__Impl"
    // InternalComputerDsl.g:3727:1: rule__Storage__Group__6__Impl : ( ( rule__Storage__TypeAssignment_6 ) ) ;
    public final void rule__Storage__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3731:1: ( ( ( rule__Storage__TypeAssignment_6 ) ) )
            // InternalComputerDsl.g:3732:1: ( ( rule__Storage__TypeAssignment_6 ) )
            {
            // InternalComputerDsl.g:3732:1: ( ( rule__Storage__TypeAssignment_6 ) )
            // InternalComputerDsl.g:3733:2: ( rule__Storage__TypeAssignment_6 )
            {
             before(grammarAccess.getStorageAccess().getTypeAssignment_6()); 
            // InternalComputerDsl.g:3734:2: ( rule__Storage__TypeAssignment_6 )
            // InternalComputerDsl.g:3734:3: rule__Storage__TypeAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Storage__TypeAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getStorageAccess().getTypeAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__6__Impl"


    // $ANTLR start "rule__Storage__Group__7"
    // InternalComputerDsl.g:3742:1: rule__Storage__Group__7 : rule__Storage__Group__7__Impl rule__Storage__Group__8 ;
    public final void rule__Storage__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3746:1: ( rule__Storage__Group__7__Impl rule__Storage__Group__8 )
            // InternalComputerDsl.g:3747:2: rule__Storage__Group__7__Impl rule__Storage__Group__8
            {
            pushFollow(FOLLOW_19);
            rule__Storage__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Storage__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__7"


    // $ANTLR start "rule__Storage__Group__7__Impl"
    // InternalComputerDsl.g:3754:1: rule__Storage__Group__7__Impl : ( 'capacity' ) ;
    public final void rule__Storage__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3758:1: ( ( 'capacity' ) )
            // InternalComputerDsl.g:3759:1: ( 'capacity' )
            {
            // InternalComputerDsl.g:3759:1: ( 'capacity' )
            // InternalComputerDsl.g:3760:2: 'capacity'
            {
             before(grammarAccess.getStorageAccess().getCapacityKeyword_7()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getStorageAccess().getCapacityKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__7__Impl"


    // $ANTLR start "rule__Storage__Group__8"
    // InternalComputerDsl.g:3769:1: rule__Storage__Group__8 : rule__Storage__Group__8__Impl rule__Storage__Group__9 ;
    public final void rule__Storage__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3773:1: ( rule__Storage__Group__8__Impl rule__Storage__Group__9 )
            // InternalComputerDsl.g:3774:2: rule__Storage__Group__8__Impl rule__Storage__Group__9
            {
            pushFollow(FOLLOW_16);
            rule__Storage__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Storage__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__8"


    // $ANTLR start "rule__Storage__Group__8__Impl"
    // InternalComputerDsl.g:3781:1: rule__Storage__Group__8__Impl : ( ( rule__Storage__CapacityAssignment_8 ) ) ;
    public final void rule__Storage__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3785:1: ( ( ( rule__Storage__CapacityAssignment_8 ) ) )
            // InternalComputerDsl.g:3786:1: ( ( rule__Storage__CapacityAssignment_8 ) )
            {
            // InternalComputerDsl.g:3786:1: ( ( rule__Storage__CapacityAssignment_8 ) )
            // InternalComputerDsl.g:3787:2: ( rule__Storage__CapacityAssignment_8 )
            {
             before(grammarAccess.getStorageAccess().getCapacityAssignment_8()); 
            // InternalComputerDsl.g:3788:2: ( rule__Storage__CapacityAssignment_8 )
            // InternalComputerDsl.g:3788:3: rule__Storage__CapacityAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Storage__CapacityAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getStorageAccess().getCapacityAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__8__Impl"


    // $ANTLR start "rule__Storage__Group__9"
    // InternalComputerDsl.g:3796:1: rule__Storage__Group__9 : rule__Storage__Group__9__Impl ;
    public final void rule__Storage__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3800:1: ( rule__Storage__Group__9__Impl )
            // InternalComputerDsl.g:3801:2: rule__Storage__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Storage__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__9"


    // $ANTLR start "rule__Storage__Group__9__Impl"
    // InternalComputerDsl.g:3807:1: rule__Storage__Group__9__Impl : ( '}' ) ;
    public final void rule__Storage__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3811:1: ( ( '}' ) )
            // InternalComputerDsl.g:3812:1: ( '}' )
            {
            // InternalComputerDsl.g:3812:1: ( '}' )
            // InternalComputerDsl.g:3813:2: '}'
            {
             before(grammarAccess.getStorageAccess().getRightCurlyBracketKeyword_9()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getStorageAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__Group__9__Impl"


    // $ANTLR start "rule__Drive__Group__0"
    // InternalComputerDsl.g:3823:1: rule__Drive__Group__0 : rule__Drive__Group__0__Impl rule__Drive__Group__1 ;
    public final void rule__Drive__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3827:1: ( rule__Drive__Group__0__Impl rule__Drive__Group__1 )
            // InternalComputerDsl.g:3828:2: rule__Drive__Group__0__Impl rule__Drive__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Drive__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Drive__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__Group__0"


    // $ANTLR start "rule__Drive__Group__0__Impl"
    // InternalComputerDsl.g:3835:1: rule__Drive__Group__0__Impl : ( 'drive' ) ;
    public final void rule__Drive__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3839:1: ( ( 'drive' ) )
            // InternalComputerDsl.g:3840:1: ( 'drive' )
            {
            // InternalComputerDsl.g:3840:1: ( 'drive' )
            // InternalComputerDsl.g:3841:2: 'drive'
            {
             before(grammarAccess.getDriveAccess().getDriveKeyword_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getDriveAccess().getDriveKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__Group__0__Impl"


    // $ANTLR start "rule__Drive__Group__1"
    // InternalComputerDsl.g:3850:1: rule__Drive__Group__1 : rule__Drive__Group__1__Impl rule__Drive__Group__2 ;
    public final void rule__Drive__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3854:1: ( rule__Drive__Group__1__Impl rule__Drive__Group__2 )
            // InternalComputerDsl.g:3855:2: rule__Drive__Group__1__Impl rule__Drive__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Drive__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Drive__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__Group__1"


    // $ANTLR start "rule__Drive__Group__1__Impl"
    // InternalComputerDsl.g:3862:1: rule__Drive__Group__1__Impl : ( ( rule__Drive__NameAssignment_1 ) ) ;
    public final void rule__Drive__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3866:1: ( ( ( rule__Drive__NameAssignment_1 ) ) )
            // InternalComputerDsl.g:3867:1: ( ( rule__Drive__NameAssignment_1 ) )
            {
            // InternalComputerDsl.g:3867:1: ( ( rule__Drive__NameAssignment_1 ) )
            // InternalComputerDsl.g:3868:2: ( rule__Drive__NameAssignment_1 )
            {
             before(grammarAccess.getDriveAccess().getNameAssignment_1()); 
            // InternalComputerDsl.g:3869:2: ( rule__Drive__NameAssignment_1 )
            // InternalComputerDsl.g:3869:3: rule__Drive__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Drive__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDriveAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__Group__1__Impl"


    // $ANTLR start "rule__Drive__Group__2"
    // InternalComputerDsl.g:3877:1: rule__Drive__Group__2 : rule__Drive__Group__2__Impl rule__Drive__Group__3 ;
    public final void rule__Drive__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3881:1: ( rule__Drive__Group__2__Impl rule__Drive__Group__3 )
            // InternalComputerDsl.g:3882:2: rule__Drive__Group__2__Impl rule__Drive__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__Drive__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Drive__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__Group__2"


    // $ANTLR start "rule__Drive__Group__2__Impl"
    // InternalComputerDsl.g:3889:1: rule__Drive__Group__2__Impl : ( '{' ) ;
    public final void rule__Drive__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3893:1: ( ( '{' ) )
            // InternalComputerDsl.g:3894:1: ( '{' )
            {
            // InternalComputerDsl.g:3894:1: ( '{' )
            // InternalComputerDsl.g:3895:2: '{'
            {
             before(grammarAccess.getDriveAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getDriveAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__Group__2__Impl"


    // $ANTLR start "rule__Drive__Group__3"
    // InternalComputerDsl.g:3904:1: rule__Drive__Group__3 : rule__Drive__Group__3__Impl rule__Drive__Group__4 ;
    public final void rule__Drive__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3908:1: ( rule__Drive__Group__3__Impl rule__Drive__Group__4 )
            // InternalComputerDsl.g:3909:2: rule__Drive__Group__3__Impl rule__Drive__Group__4
            {
            pushFollow(FOLLOW_19);
            rule__Drive__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Drive__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__Group__3"


    // $ANTLR start "rule__Drive__Group__3__Impl"
    // InternalComputerDsl.g:3916:1: rule__Drive__Group__3__Impl : ( 'power' ) ;
    public final void rule__Drive__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3920:1: ( ( 'power' ) )
            // InternalComputerDsl.g:3921:1: ( 'power' )
            {
            // InternalComputerDsl.g:3921:1: ( 'power' )
            // InternalComputerDsl.g:3922:2: 'power'
            {
             before(grammarAccess.getDriveAccess().getPowerKeyword_3()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getDriveAccess().getPowerKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__Group__3__Impl"


    // $ANTLR start "rule__Drive__Group__4"
    // InternalComputerDsl.g:3931:1: rule__Drive__Group__4 : rule__Drive__Group__4__Impl rule__Drive__Group__5 ;
    public final void rule__Drive__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3935:1: ( rule__Drive__Group__4__Impl rule__Drive__Group__5 )
            // InternalComputerDsl.g:3936:2: rule__Drive__Group__4__Impl rule__Drive__Group__5
            {
            pushFollow(FOLLOW_20);
            rule__Drive__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Drive__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__Group__4"


    // $ANTLR start "rule__Drive__Group__4__Impl"
    // InternalComputerDsl.g:3943:1: rule__Drive__Group__4__Impl : ( ( rule__Drive__PowerAssignment_4 ) ) ;
    public final void rule__Drive__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3947:1: ( ( ( rule__Drive__PowerAssignment_4 ) ) )
            // InternalComputerDsl.g:3948:1: ( ( rule__Drive__PowerAssignment_4 ) )
            {
            // InternalComputerDsl.g:3948:1: ( ( rule__Drive__PowerAssignment_4 ) )
            // InternalComputerDsl.g:3949:2: ( rule__Drive__PowerAssignment_4 )
            {
             before(grammarAccess.getDriveAccess().getPowerAssignment_4()); 
            // InternalComputerDsl.g:3950:2: ( rule__Drive__PowerAssignment_4 )
            // InternalComputerDsl.g:3950:3: rule__Drive__PowerAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Drive__PowerAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDriveAccess().getPowerAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__Group__4__Impl"


    // $ANTLR start "rule__Drive__Group__5"
    // InternalComputerDsl.g:3958:1: rule__Drive__Group__5 : rule__Drive__Group__5__Impl rule__Drive__Group__6 ;
    public final void rule__Drive__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3962:1: ( rule__Drive__Group__5__Impl rule__Drive__Group__6 )
            // InternalComputerDsl.g:3963:2: rule__Drive__Group__5__Impl rule__Drive__Group__6
            {
            pushFollow(FOLLOW_34);
            rule__Drive__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Drive__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__Group__5"


    // $ANTLR start "rule__Drive__Group__5__Impl"
    // InternalComputerDsl.g:3970:1: rule__Drive__Group__5__Impl : ( 'type' ) ;
    public final void rule__Drive__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3974:1: ( ( 'type' ) )
            // InternalComputerDsl.g:3975:1: ( 'type' )
            {
            // InternalComputerDsl.g:3975:1: ( 'type' )
            // InternalComputerDsl.g:3976:2: 'type'
            {
             before(grammarAccess.getDriveAccess().getTypeKeyword_5()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getDriveAccess().getTypeKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__Group__5__Impl"


    // $ANTLR start "rule__Drive__Group__6"
    // InternalComputerDsl.g:3985:1: rule__Drive__Group__6 : rule__Drive__Group__6__Impl rule__Drive__Group__7 ;
    public final void rule__Drive__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:3989:1: ( rule__Drive__Group__6__Impl rule__Drive__Group__7 )
            // InternalComputerDsl.g:3990:2: rule__Drive__Group__6__Impl rule__Drive__Group__7
            {
            pushFollow(FOLLOW_16);
            rule__Drive__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Drive__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__Group__6"


    // $ANTLR start "rule__Drive__Group__6__Impl"
    // InternalComputerDsl.g:3997:1: rule__Drive__Group__6__Impl : ( ( rule__Drive__TypeAssignment_6 ) ) ;
    public final void rule__Drive__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4001:1: ( ( ( rule__Drive__TypeAssignment_6 ) ) )
            // InternalComputerDsl.g:4002:1: ( ( rule__Drive__TypeAssignment_6 ) )
            {
            // InternalComputerDsl.g:4002:1: ( ( rule__Drive__TypeAssignment_6 ) )
            // InternalComputerDsl.g:4003:2: ( rule__Drive__TypeAssignment_6 )
            {
             before(grammarAccess.getDriveAccess().getTypeAssignment_6()); 
            // InternalComputerDsl.g:4004:2: ( rule__Drive__TypeAssignment_6 )
            // InternalComputerDsl.g:4004:3: rule__Drive__TypeAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Drive__TypeAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getDriveAccess().getTypeAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__Group__6__Impl"


    // $ANTLR start "rule__Drive__Group__7"
    // InternalComputerDsl.g:4012:1: rule__Drive__Group__7 : rule__Drive__Group__7__Impl ;
    public final void rule__Drive__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4016:1: ( rule__Drive__Group__7__Impl )
            // InternalComputerDsl.g:4017:2: rule__Drive__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Drive__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__Group__7"


    // $ANTLR start "rule__Drive__Group__7__Impl"
    // InternalComputerDsl.g:4023:1: rule__Drive__Group__7__Impl : ( '}' ) ;
    public final void rule__Drive__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4027:1: ( ( '}' ) )
            // InternalComputerDsl.g:4028:1: ( '}' )
            {
            // InternalComputerDsl.g:4028:1: ( '}' )
            // InternalComputerDsl.g:4029:2: '}'
            {
             before(grammarAccess.getDriveAccess().getRightCurlyBracketKeyword_7()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getDriveAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__Group__7__Impl"


    // $ANTLR start "rule__Peripheral__Group__0"
    // InternalComputerDsl.g:4039:1: rule__Peripheral__Group__0 : rule__Peripheral__Group__0__Impl rule__Peripheral__Group__1 ;
    public final void rule__Peripheral__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4043:1: ( rule__Peripheral__Group__0__Impl rule__Peripheral__Group__1 )
            // InternalComputerDsl.g:4044:2: rule__Peripheral__Group__0__Impl rule__Peripheral__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Peripheral__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Peripheral__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__Group__0"


    // $ANTLR start "rule__Peripheral__Group__0__Impl"
    // InternalComputerDsl.g:4051:1: rule__Peripheral__Group__0__Impl : ( ( rule__Peripheral__KindAssignment_0 ) ) ;
    public final void rule__Peripheral__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4055:1: ( ( ( rule__Peripheral__KindAssignment_0 ) ) )
            // InternalComputerDsl.g:4056:1: ( ( rule__Peripheral__KindAssignment_0 ) )
            {
            // InternalComputerDsl.g:4056:1: ( ( rule__Peripheral__KindAssignment_0 ) )
            // InternalComputerDsl.g:4057:2: ( rule__Peripheral__KindAssignment_0 )
            {
             before(grammarAccess.getPeripheralAccess().getKindAssignment_0()); 
            // InternalComputerDsl.g:4058:2: ( rule__Peripheral__KindAssignment_0 )
            // InternalComputerDsl.g:4058:3: rule__Peripheral__KindAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Peripheral__KindAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPeripheralAccess().getKindAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__Group__0__Impl"


    // $ANTLR start "rule__Peripheral__Group__1"
    // InternalComputerDsl.g:4066:1: rule__Peripheral__Group__1 : rule__Peripheral__Group__1__Impl rule__Peripheral__Group__2 ;
    public final void rule__Peripheral__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4070:1: ( rule__Peripheral__Group__1__Impl rule__Peripheral__Group__2 )
            // InternalComputerDsl.g:4071:2: rule__Peripheral__Group__1__Impl rule__Peripheral__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Peripheral__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Peripheral__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__Group__1"


    // $ANTLR start "rule__Peripheral__Group__1__Impl"
    // InternalComputerDsl.g:4078:1: rule__Peripheral__Group__1__Impl : ( ( rule__Peripheral__NameAssignment_1 ) ) ;
    public final void rule__Peripheral__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4082:1: ( ( ( rule__Peripheral__NameAssignment_1 ) ) )
            // InternalComputerDsl.g:4083:1: ( ( rule__Peripheral__NameAssignment_1 ) )
            {
            // InternalComputerDsl.g:4083:1: ( ( rule__Peripheral__NameAssignment_1 ) )
            // InternalComputerDsl.g:4084:2: ( rule__Peripheral__NameAssignment_1 )
            {
             before(grammarAccess.getPeripheralAccess().getNameAssignment_1()); 
            // InternalComputerDsl.g:4085:2: ( rule__Peripheral__NameAssignment_1 )
            // InternalComputerDsl.g:4085:3: rule__Peripheral__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Peripheral__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPeripheralAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__Group__1__Impl"


    // $ANTLR start "rule__Peripheral__Group__2"
    // InternalComputerDsl.g:4093:1: rule__Peripheral__Group__2 : rule__Peripheral__Group__2__Impl rule__Peripheral__Group__3 ;
    public final void rule__Peripheral__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4097:1: ( rule__Peripheral__Group__2__Impl rule__Peripheral__Group__3 )
            // InternalComputerDsl.g:4098:2: rule__Peripheral__Group__2__Impl rule__Peripheral__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__Peripheral__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Peripheral__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__Group__2"


    // $ANTLR start "rule__Peripheral__Group__2__Impl"
    // InternalComputerDsl.g:4105:1: rule__Peripheral__Group__2__Impl : ( '{' ) ;
    public final void rule__Peripheral__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4109:1: ( ( '{' ) )
            // InternalComputerDsl.g:4110:1: ( '{' )
            {
            // InternalComputerDsl.g:4110:1: ( '{' )
            // InternalComputerDsl.g:4111:2: '{'
            {
             before(grammarAccess.getPeripheralAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getPeripheralAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__Group__2__Impl"


    // $ANTLR start "rule__Peripheral__Group__3"
    // InternalComputerDsl.g:4120:1: rule__Peripheral__Group__3 : rule__Peripheral__Group__3__Impl rule__Peripheral__Group__4 ;
    public final void rule__Peripheral__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4124:1: ( rule__Peripheral__Group__3__Impl rule__Peripheral__Group__4 )
            // InternalComputerDsl.g:4125:2: rule__Peripheral__Group__3__Impl rule__Peripheral__Group__4
            {
            pushFollow(FOLLOW_19);
            rule__Peripheral__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Peripheral__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__Group__3"


    // $ANTLR start "rule__Peripheral__Group__3__Impl"
    // InternalComputerDsl.g:4132:1: rule__Peripheral__Group__3__Impl : ( 'power' ) ;
    public final void rule__Peripheral__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4136:1: ( ( 'power' ) )
            // InternalComputerDsl.g:4137:1: ( 'power' )
            {
            // InternalComputerDsl.g:4137:1: ( 'power' )
            // InternalComputerDsl.g:4138:2: 'power'
            {
             before(grammarAccess.getPeripheralAccess().getPowerKeyword_3()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getPeripheralAccess().getPowerKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__Group__3__Impl"


    // $ANTLR start "rule__Peripheral__Group__4"
    // InternalComputerDsl.g:4147:1: rule__Peripheral__Group__4 : rule__Peripheral__Group__4__Impl rule__Peripheral__Group__5 ;
    public final void rule__Peripheral__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4151:1: ( rule__Peripheral__Group__4__Impl rule__Peripheral__Group__5 )
            // InternalComputerDsl.g:4152:2: rule__Peripheral__Group__4__Impl rule__Peripheral__Group__5
            {
            pushFollow(FOLLOW_35);
            rule__Peripheral__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Peripheral__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__Group__4"


    // $ANTLR start "rule__Peripheral__Group__4__Impl"
    // InternalComputerDsl.g:4159:1: rule__Peripheral__Group__4__Impl : ( ( rule__Peripheral__PowerAssignment_4 ) ) ;
    public final void rule__Peripheral__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4163:1: ( ( ( rule__Peripheral__PowerAssignment_4 ) ) )
            // InternalComputerDsl.g:4164:1: ( ( rule__Peripheral__PowerAssignment_4 ) )
            {
            // InternalComputerDsl.g:4164:1: ( ( rule__Peripheral__PowerAssignment_4 ) )
            // InternalComputerDsl.g:4165:2: ( rule__Peripheral__PowerAssignment_4 )
            {
             before(grammarAccess.getPeripheralAccess().getPowerAssignment_4()); 
            // InternalComputerDsl.g:4166:2: ( rule__Peripheral__PowerAssignment_4 )
            // InternalComputerDsl.g:4166:3: rule__Peripheral__PowerAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Peripheral__PowerAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPeripheralAccess().getPowerAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__Group__4__Impl"


    // $ANTLR start "rule__Peripheral__Group__5"
    // InternalComputerDsl.g:4174:1: rule__Peripheral__Group__5 : rule__Peripheral__Group__5__Impl rule__Peripheral__Group__6 ;
    public final void rule__Peripheral__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4178:1: ( rule__Peripheral__Group__5__Impl rule__Peripheral__Group__6 )
            // InternalComputerDsl.g:4179:2: rule__Peripheral__Group__5__Impl rule__Peripheral__Group__6
            {
            pushFollow(FOLLOW_27);
            rule__Peripheral__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Peripheral__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__Group__5"


    // $ANTLR start "rule__Peripheral__Group__5__Impl"
    // InternalComputerDsl.g:4186:1: rule__Peripheral__Group__5__Impl : ( 'port' ) ;
    public final void rule__Peripheral__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4190:1: ( ( 'port' ) )
            // InternalComputerDsl.g:4191:1: ( 'port' )
            {
            // InternalComputerDsl.g:4191:1: ( 'port' )
            // InternalComputerDsl.g:4192:2: 'port'
            {
             before(grammarAccess.getPeripheralAccess().getPortKeyword_5()); 
            match(input,68,FOLLOW_2); 
             after(grammarAccess.getPeripheralAccess().getPortKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__Group__5__Impl"


    // $ANTLR start "rule__Peripheral__Group__6"
    // InternalComputerDsl.g:4201:1: rule__Peripheral__Group__6 : rule__Peripheral__Group__6__Impl rule__Peripheral__Group__7 ;
    public final void rule__Peripheral__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4205:1: ( rule__Peripheral__Group__6__Impl rule__Peripheral__Group__7 )
            // InternalComputerDsl.g:4206:2: rule__Peripheral__Group__6__Impl rule__Peripheral__Group__7
            {
            pushFollow(FOLLOW_16);
            rule__Peripheral__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Peripheral__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__Group__6"


    // $ANTLR start "rule__Peripheral__Group__6__Impl"
    // InternalComputerDsl.g:4213:1: rule__Peripheral__Group__6__Impl : ( ( rule__Peripheral__PortAssignment_6 ) ) ;
    public final void rule__Peripheral__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4217:1: ( ( ( rule__Peripheral__PortAssignment_6 ) ) )
            // InternalComputerDsl.g:4218:1: ( ( rule__Peripheral__PortAssignment_6 ) )
            {
            // InternalComputerDsl.g:4218:1: ( ( rule__Peripheral__PortAssignment_6 ) )
            // InternalComputerDsl.g:4219:2: ( rule__Peripheral__PortAssignment_6 )
            {
             before(grammarAccess.getPeripheralAccess().getPortAssignment_6()); 
            // InternalComputerDsl.g:4220:2: ( rule__Peripheral__PortAssignment_6 )
            // InternalComputerDsl.g:4220:3: rule__Peripheral__PortAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Peripheral__PortAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getPeripheralAccess().getPortAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__Group__6__Impl"


    // $ANTLR start "rule__Peripheral__Group__7"
    // InternalComputerDsl.g:4228:1: rule__Peripheral__Group__7 : rule__Peripheral__Group__7__Impl ;
    public final void rule__Peripheral__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4232:1: ( rule__Peripheral__Group__7__Impl )
            // InternalComputerDsl.g:4233:2: rule__Peripheral__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Peripheral__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__Group__7"


    // $ANTLR start "rule__Peripheral__Group__7__Impl"
    // InternalComputerDsl.g:4239:1: rule__Peripheral__Group__7__Impl : ( '}' ) ;
    public final void rule__Peripheral__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4243:1: ( ( '}' ) )
            // InternalComputerDsl.g:4244:1: ( '}' )
            {
            // InternalComputerDsl.g:4244:1: ( '}' )
            // InternalComputerDsl.g:4245:2: '}'
            {
             before(grammarAccess.getPeripheralAccess().getRightCurlyBracketKeyword_7()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getPeripheralAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__Group__7__Impl"


    // $ANTLR start "rule__PowerSupply__Group__0"
    // InternalComputerDsl.g:4255:1: rule__PowerSupply__Group__0 : rule__PowerSupply__Group__0__Impl rule__PowerSupply__Group__1 ;
    public final void rule__PowerSupply__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4259:1: ( rule__PowerSupply__Group__0__Impl rule__PowerSupply__Group__1 )
            // InternalComputerDsl.g:4260:2: rule__PowerSupply__Group__0__Impl rule__PowerSupply__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__PowerSupply__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PowerSupply__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__Group__0"


    // $ANTLR start "rule__PowerSupply__Group__0__Impl"
    // InternalComputerDsl.g:4267:1: rule__PowerSupply__Group__0__Impl : ( 'psu' ) ;
    public final void rule__PowerSupply__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4271:1: ( ( 'psu' ) )
            // InternalComputerDsl.g:4272:1: ( 'psu' )
            {
            // InternalComputerDsl.g:4272:1: ( 'psu' )
            // InternalComputerDsl.g:4273:2: 'psu'
            {
             before(grammarAccess.getPowerSupplyAccess().getPsuKeyword_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getPowerSupplyAccess().getPsuKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__Group__0__Impl"


    // $ANTLR start "rule__PowerSupply__Group__1"
    // InternalComputerDsl.g:4282:1: rule__PowerSupply__Group__1 : rule__PowerSupply__Group__1__Impl rule__PowerSupply__Group__2 ;
    public final void rule__PowerSupply__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4286:1: ( rule__PowerSupply__Group__1__Impl rule__PowerSupply__Group__2 )
            // InternalComputerDsl.g:4287:2: rule__PowerSupply__Group__1__Impl rule__PowerSupply__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__PowerSupply__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PowerSupply__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__Group__1"


    // $ANTLR start "rule__PowerSupply__Group__1__Impl"
    // InternalComputerDsl.g:4294:1: rule__PowerSupply__Group__1__Impl : ( ( rule__PowerSupply__NameAssignment_1 ) ) ;
    public final void rule__PowerSupply__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4298:1: ( ( ( rule__PowerSupply__NameAssignment_1 ) ) )
            // InternalComputerDsl.g:4299:1: ( ( rule__PowerSupply__NameAssignment_1 ) )
            {
            // InternalComputerDsl.g:4299:1: ( ( rule__PowerSupply__NameAssignment_1 ) )
            // InternalComputerDsl.g:4300:2: ( rule__PowerSupply__NameAssignment_1 )
            {
             before(grammarAccess.getPowerSupplyAccess().getNameAssignment_1()); 
            // InternalComputerDsl.g:4301:2: ( rule__PowerSupply__NameAssignment_1 )
            // InternalComputerDsl.g:4301:3: rule__PowerSupply__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PowerSupply__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPowerSupplyAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__Group__1__Impl"


    // $ANTLR start "rule__PowerSupply__Group__2"
    // InternalComputerDsl.g:4309:1: rule__PowerSupply__Group__2 : rule__PowerSupply__Group__2__Impl rule__PowerSupply__Group__3 ;
    public final void rule__PowerSupply__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4313:1: ( rule__PowerSupply__Group__2__Impl rule__PowerSupply__Group__3 )
            // InternalComputerDsl.g:4314:2: rule__PowerSupply__Group__2__Impl rule__PowerSupply__Group__3
            {
            pushFollow(FOLLOW_32);
            rule__PowerSupply__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PowerSupply__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__Group__2"


    // $ANTLR start "rule__PowerSupply__Group__2__Impl"
    // InternalComputerDsl.g:4321:1: rule__PowerSupply__Group__2__Impl : ( '{' ) ;
    public final void rule__PowerSupply__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4325:1: ( ( '{' ) )
            // InternalComputerDsl.g:4326:1: ( '{' )
            {
            // InternalComputerDsl.g:4326:1: ( '{' )
            // InternalComputerDsl.g:4327:2: '{'
            {
             before(grammarAccess.getPowerSupplyAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getPowerSupplyAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__Group__2__Impl"


    // $ANTLR start "rule__PowerSupply__Group__3"
    // InternalComputerDsl.g:4336:1: rule__PowerSupply__Group__3 : rule__PowerSupply__Group__3__Impl rule__PowerSupply__Group__4 ;
    public final void rule__PowerSupply__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4340:1: ( rule__PowerSupply__Group__3__Impl rule__PowerSupply__Group__4 )
            // InternalComputerDsl.g:4341:2: rule__PowerSupply__Group__3__Impl rule__PowerSupply__Group__4
            {
            pushFollow(FOLLOW_19);
            rule__PowerSupply__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PowerSupply__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__Group__3"


    // $ANTLR start "rule__PowerSupply__Group__3__Impl"
    // InternalComputerDsl.g:4348:1: rule__PowerSupply__Group__3__Impl : ( 'capacity' ) ;
    public final void rule__PowerSupply__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4352:1: ( ( 'capacity' ) )
            // InternalComputerDsl.g:4353:1: ( 'capacity' )
            {
            // InternalComputerDsl.g:4353:1: ( 'capacity' )
            // InternalComputerDsl.g:4354:2: 'capacity'
            {
             before(grammarAccess.getPowerSupplyAccess().getCapacityKeyword_3()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getPowerSupplyAccess().getCapacityKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__Group__3__Impl"


    // $ANTLR start "rule__PowerSupply__Group__4"
    // InternalComputerDsl.g:4363:1: rule__PowerSupply__Group__4 : rule__PowerSupply__Group__4__Impl rule__PowerSupply__Group__5 ;
    public final void rule__PowerSupply__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4367:1: ( rule__PowerSupply__Group__4__Impl rule__PowerSupply__Group__5 )
            // InternalComputerDsl.g:4368:2: rule__PowerSupply__Group__4__Impl rule__PowerSupply__Group__5
            {
            pushFollow(FOLLOW_36);
            rule__PowerSupply__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PowerSupply__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__Group__4"


    // $ANTLR start "rule__PowerSupply__Group__4__Impl"
    // InternalComputerDsl.g:4375:1: rule__PowerSupply__Group__4__Impl : ( ( rule__PowerSupply__CapacityAssignment_4 ) ) ;
    public final void rule__PowerSupply__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4379:1: ( ( ( rule__PowerSupply__CapacityAssignment_4 ) ) )
            // InternalComputerDsl.g:4380:1: ( ( rule__PowerSupply__CapacityAssignment_4 ) )
            {
            // InternalComputerDsl.g:4380:1: ( ( rule__PowerSupply__CapacityAssignment_4 ) )
            // InternalComputerDsl.g:4381:2: ( rule__PowerSupply__CapacityAssignment_4 )
            {
             before(grammarAccess.getPowerSupplyAccess().getCapacityAssignment_4()); 
            // InternalComputerDsl.g:4382:2: ( rule__PowerSupply__CapacityAssignment_4 )
            // InternalComputerDsl.g:4382:3: rule__PowerSupply__CapacityAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__PowerSupply__CapacityAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPowerSupplyAccess().getCapacityAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__Group__4__Impl"


    // $ANTLR start "rule__PowerSupply__Group__5"
    // InternalComputerDsl.g:4390:1: rule__PowerSupply__Group__5 : rule__PowerSupply__Group__5__Impl rule__PowerSupply__Group__6 ;
    public final void rule__PowerSupply__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4394:1: ( rule__PowerSupply__Group__5__Impl rule__PowerSupply__Group__6 )
            // InternalComputerDsl.g:4395:2: rule__PowerSupply__Group__5__Impl rule__PowerSupply__Group__6
            {
            pushFollow(FOLLOW_37);
            rule__PowerSupply__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PowerSupply__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__Group__5"


    // $ANTLR start "rule__PowerSupply__Group__5__Impl"
    // InternalComputerDsl.g:4402:1: rule__PowerSupply__Group__5__Impl : ( 'rating' ) ;
    public final void rule__PowerSupply__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4406:1: ( ( 'rating' ) )
            // InternalComputerDsl.g:4407:1: ( 'rating' )
            {
            // InternalComputerDsl.g:4407:1: ( 'rating' )
            // InternalComputerDsl.g:4408:2: 'rating'
            {
             before(grammarAccess.getPowerSupplyAccess().getRatingKeyword_5()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getPowerSupplyAccess().getRatingKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__Group__5__Impl"


    // $ANTLR start "rule__PowerSupply__Group__6"
    // InternalComputerDsl.g:4417:1: rule__PowerSupply__Group__6 : rule__PowerSupply__Group__6__Impl rule__PowerSupply__Group__7 ;
    public final void rule__PowerSupply__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4421:1: ( rule__PowerSupply__Group__6__Impl rule__PowerSupply__Group__7 )
            // InternalComputerDsl.g:4422:2: rule__PowerSupply__Group__6__Impl rule__PowerSupply__Group__7
            {
            pushFollow(FOLLOW_16);
            rule__PowerSupply__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PowerSupply__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__Group__6"


    // $ANTLR start "rule__PowerSupply__Group__6__Impl"
    // InternalComputerDsl.g:4429:1: rule__PowerSupply__Group__6__Impl : ( ( rule__PowerSupply__RatingAssignment_6 ) ) ;
    public final void rule__PowerSupply__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4433:1: ( ( ( rule__PowerSupply__RatingAssignment_6 ) ) )
            // InternalComputerDsl.g:4434:1: ( ( rule__PowerSupply__RatingAssignment_6 ) )
            {
            // InternalComputerDsl.g:4434:1: ( ( rule__PowerSupply__RatingAssignment_6 ) )
            // InternalComputerDsl.g:4435:2: ( rule__PowerSupply__RatingAssignment_6 )
            {
             before(grammarAccess.getPowerSupplyAccess().getRatingAssignment_6()); 
            // InternalComputerDsl.g:4436:2: ( rule__PowerSupply__RatingAssignment_6 )
            // InternalComputerDsl.g:4436:3: rule__PowerSupply__RatingAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__PowerSupply__RatingAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getPowerSupplyAccess().getRatingAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__Group__6__Impl"


    // $ANTLR start "rule__PowerSupply__Group__7"
    // InternalComputerDsl.g:4444:1: rule__PowerSupply__Group__7 : rule__PowerSupply__Group__7__Impl ;
    public final void rule__PowerSupply__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4448:1: ( rule__PowerSupply__Group__7__Impl )
            // InternalComputerDsl.g:4449:2: rule__PowerSupply__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PowerSupply__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__Group__7"


    // $ANTLR start "rule__PowerSupply__Group__7__Impl"
    // InternalComputerDsl.g:4455:1: rule__PowerSupply__Group__7__Impl : ( '}' ) ;
    public final void rule__PowerSupply__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4459:1: ( ( '}' ) )
            // InternalComputerDsl.g:4460:1: ( '}' )
            {
            // InternalComputerDsl.g:4460:1: ( '}' )
            // InternalComputerDsl.g:4461:2: '}'
            {
             before(grammarAccess.getPowerSupplyAccess().getRightCurlyBracketKeyword_7()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getPowerSupplyAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__Group__7__Impl"


    // $ANTLR start "rule__Model__ElementsAssignment"
    // InternalComputerDsl.g:4471:1: rule__Model__ElementsAssignment : ( ruleAbstractElement ) ;
    public final void rule__Model__ElementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4475:1: ( ( ruleAbstractElement ) )
            // InternalComputerDsl.g:4476:2: ( ruleAbstractElement )
            {
            // InternalComputerDsl.g:4476:2: ( ruleAbstractElement )
            // InternalComputerDsl.g:4477:3: ruleAbstractElement
            {
             before(grammarAccess.getModelAccess().getElementsAbstractElementParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getModelAccess().getElementsAbstractElementParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ElementsAssignment"


    // $ANTLR start "rule__PackageDeclaration__NameAssignment_1"
    // InternalComputerDsl.g:4486:1: rule__PackageDeclaration__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDeclaration__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4490:1: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:4491:2: ( ruleQualifiedName )
            {
            // InternalComputerDsl.g:4491:2: ( ruleQualifiedName )
            // InternalComputerDsl.g:4492:3: ruleQualifiedName
            {
             before(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationAccess().getNameQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__NameAssignment_1"


    // $ANTLR start "rule__PackageDeclaration__ElementsAssignment_3"
    // InternalComputerDsl.g:4501:1: rule__PackageDeclaration__ElementsAssignment_3 : ( ruleAbstractElement ) ;
    public final void rule__PackageDeclaration__ElementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4505:1: ( ( ruleAbstractElement ) )
            // InternalComputerDsl.g:4506:2: ( ruleAbstractElement )
            {
            // InternalComputerDsl.g:4506:2: ( ruleAbstractElement )
            // InternalComputerDsl.g:4507:3: ruleAbstractElement
            {
             before(grammarAccess.getPackageDeclarationAccess().getElementsAbstractElementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleAbstractElement();

            state._fsp--;

             after(grammarAccess.getPackageDeclarationAccess().getElementsAbstractElementParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDeclaration__ElementsAssignment_3"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1"
    // InternalComputerDsl.g:4516:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4520:1: ( ( ruleQualifiedNameWithWildcard ) )
            // InternalComputerDsl.g:4521:2: ( ruleQualifiedNameWithWildcard )
            {
            // InternalComputerDsl.g:4521:2: ( ruleQualifiedNameWithWildcard )
            // InternalComputerDsl.g:4522:3: ruleQualifiedNameWithWildcard
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedNameWithWildcard();

            state._fsp--;

             after(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ImportedNamespaceAssignment_1"


    // $ANTLR start "rule__Computer__NameAssignment_1"
    // InternalComputerDsl.g:4531:1: rule__Computer__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Computer__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4535:1: ( ( RULE_ID ) )
            // InternalComputerDsl.g:4536:2: ( RULE_ID )
            {
            // InternalComputerDsl.g:4536:2: ( RULE_ID )
            // InternalComputerDsl.g:4537:3: RULE_ID
            {
             before(grammarAccess.getComputerAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getComputerAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__NameAssignment_1"


    // $ANTLR start "rule__Computer__MotherboardAssignment_4"
    // InternalComputerDsl.g:4546:1: rule__Computer__MotherboardAssignment_4 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Computer__MotherboardAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4550:1: ( ( ( ruleQualifiedName ) ) )
            // InternalComputerDsl.g:4551:2: ( ( ruleQualifiedName ) )
            {
            // InternalComputerDsl.g:4551:2: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:4552:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getComputerAccess().getMotherboardMotherboardCrossReference_4_0()); 
            // InternalComputerDsl.g:4553:3: ( ruleQualifiedName )
            // InternalComputerDsl.g:4554:4: ruleQualifiedName
            {
             before(grammarAccess.getComputerAccess().getMotherboardMotherboardQualifiedNameParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getComputerAccess().getMotherboardMotherboardQualifiedNameParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getComputerAccess().getMotherboardMotherboardCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__MotherboardAssignment_4"


    // $ANTLR start "rule__Computer__ProcessorAssignment_6"
    // InternalComputerDsl.g:4565:1: rule__Computer__ProcessorAssignment_6 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Computer__ProcessorAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4569:1: ( ( ( ruleQualifiedName ) ) )
            // InternalComputerDsl.g:4570:2: ( ( ruleQualifiedName ) )
            {
            // InternalComputerDsl.g:4570:2: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:4571:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getComputerAccess().getProcessorProcessorCrossReference_6_0()); 
            // InternalComputerDsl.g:4572:3: ( ruleQualifiedName )
            // InternalComputerDsl.g:4573:4: ruleQualifiedName
            {
             before(grammarAccess.getComputerAccess().getProcessorProcessorQualifiedNameParserRuleCall_6_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getComputerAccess().getProcessorProcessorQualifiedNameParserRuleCall_6_0_1()); 

            }

             after(grammarAccess.getComputerAccess().getProcessorProcessorCrossReference_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__ProcessorAssignment_6"


    // $ANTLR start "rule__Computer__GraphicsCardAssignment_7_1"
    // InternalComputerDsl.g:4584:1: rule__Computer__GraphicsCardAssignment_7_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Computer__GraphicsCardAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4588:1: ( ( ( ruleQualifiedName ) ) )
            // InternalComputerDsl.g:4589:2: ( ( ruleQualifiedName ) )
            {
            // InternalComputerDsl.g:4589:2: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:4590:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getComputerAccess().getGraphicsCardGraphicsCardCrossReference_7_1_0()); 
            // InternalComputerDsl.g:4591:3: ( ruleQualifiedName )
            // InternalComputerDsl.g:4592:4: ruleQualifiedName
            {
             before(grammarAccess.getComputerAccess().getGraphicsCardGraphicsCardQualifiedNameParserRuleCall_7_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getComputerAccess().getGraphicsCardGraphicsCardQualifiedNameParserRuleCall_7_1_0_1()); 

            }

             after(grammarAccess.getComputerAccess().getGraphicsCardGraphicsCardCrossReference_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__GraphicsCardAssignment_7_1"


    // $ANTLR start "rule__Computer__MemoryAssignment_9"
    // InternalComputerDsl.g:4603:1: rule__Computer__MemoryAssignment_9 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Computer__MemoryAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4607:1: ( ( ( ruleQualifiedName ) ) )
            // InternalComputerDsl.g:4608:2: ( ( ruleQualifiedName ) )
            {
            // InternalComputerDsl.g:4608:2: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:4609:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getComputerAccess().getMemoryMemoryCrossReference_9_0()); 
            // InternalComputerDsl.g:4610:3: ( ruleQualifiedName )
            // InternalComputerDsl.g:4611:4: ruleQualifiedName
            {
             before(grammarAccess.getComputerAccess().getMemoryMemoryQualifiedNameParserRuleCall_9_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getComputerAccess().getMemoryMemoryQualifiedNameParserRuleCall_9_0_1()); 

            }

             after(grammarAccess.getComputerAccess().getMemoryMemoryCrossReference_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__MemoryAssignment_9"


    // $ANTLR start "rule__Computer__MemoryAssignment_10_1"
    // InternalComputerDsl.g:4622:1: rule__Computer__MemoryAssignment_10_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Computer__MemoryAssignment_10_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4626:1: ( ( ( ruleQualifiedName ) ) )
            // InternalComputerDsl.g:4627:2: ( ( ruleQualifiedName ) )
            {
            // InternalComputerDsl.g:4627:2: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:4628:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getComputerAccess().getMemoryMemoryCrossReference_10_1_0()); 
            // InternalComputerDsl.g:4629:3: ( ruleQualifiedName )
            // InternalComputerDsl.g:4630:4: ruleQualifiedName
            {
             before(grammarAccess.getComputerAccess().getMemoryMemoryQualifiedNameParserRuleCall_10_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getComputerAccess().getMemoryMemoryQualifiedNameParserRuleCall_10_1_0_1()); 

            }

             after(grammarAccess.getComputerAccess().getMemoryMemoryCrossReference_10_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__MemoryAssignment_10_1"


    // $ANTLR start "rule__Computer__StorageAssignment_12"
    // InternalComputerDsl.g:4641:1: rule__Computer__StorageAssignment_12 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Computer__StorageAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4645:1: ( ( ( ruleQualifiedName ) ) )
            // InternalComputerDsl.g:4646:2: ( ( ruleQualifiedName ) )
            {
            // InternalComputerDsl.g:4646:2: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:4647:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getComputerAccess().getStorageStorageCrossReference_12_0()); 
            // InternalComputerDsl.g:4648:3: ( ruleQualifiedName )
            // InternalComputerDsl.g:4649:4: ruleQualifiedName
            {
             before(grammarAccess.getComputerAccess().getStorageStorageQualifiedNameParserRuleCall_12_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getComputerAccess().getStorageStorageQualifiedNameParserRuleCall_12_0_1()); 

            }

             after(grammarAccess.getComputerAccess().getStorageStorageCrossReference_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__StorageAssignment_12"


    // $ANTLR start "rule__Computer__StorageAssignment_13_1"
    // InternalComputerDsl.g:4660:1: rule__Computer__StorageAssignment_13_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Computer__StorageAssignment_13_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4664:1: ( ( ( ruleQualifiedName ) ) )
            // InternalComputerDsl.g:4665:2: ( ( ruleQualifiedName ) )
            {
            // InternalComputerDsl.g:4665:2: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:4666:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getComputerAccess().getStorageStorageCrossReference_13_1_0()); 
            // InternalComputerDsl.g:4667:3: ( ruleQualifiedName )
            // InternalComputerDsl.g:4668:4: ruleQualifiedName
            {
             before(grammarAccess.getComputerAccess().getStorageStorageQualifiedNameParserRuleCall_13_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getComputerAccess().getStorageStorageQualifiedNameParserRuleCall_13_1_0_1()); 

            }

             after(grammarAccess.getComputerAccess().getStorageStorageCrossReference_13_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__StorageAssignment_13_1"


    // $ANTLR start "rule__Computer__DriveAssignment_14_1"
    // InternalComputerDsl.g:4679:1: rule__Computer__DriveAssignment_14_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Computer__DriveAssignment_14_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4683:1: ( ( ( ruleQualifiedName ) ) )
            // InternalComputerDsl.g:4684:2: ( ( ruleQualifiedName ) )
            {
            // InternalComputerDsl.g:4684:2: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:4685:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getComputerAccess().getDriveDriveCrossReference_14_1_0()); 
            // InternalComputerDsl.g:4686:3: ( ruleQualifiedName )
            // InternalComputerDsl.g:4687:4: ruleQualifiedName
            {
             before(grammarAccess.getComputerAccess().getDriveDriveQualifiedNameParserRuleCall_14_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getComputerAccess().getDriveDriveQualifiedNameParserRuleCall_14_1_0_1()); 

            }

             after(grammarAccess.getComputerAccess().getDriveDriveCrossReference_14_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__DriveAssignment_14_1"


    // $ANTLR start "rule__Computer__PeripheralsAssignment_15_1"
    // InternalComputerDsl.g:4698:1: rule__Computer__PeripheralsAssignment_15_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Computer__PeripheralsAssignment_15_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4702:1: ( ( ( ruleQualifiedName ) ) )
            // InternalComputerDsl.g:4703:2: ( ( ruleQualifiedName ) )
            {
            // InternalComputerDsl.g:4703:2: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:4704:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getComputerAccess().getPeripheralsPeripheralCrossReference_15_1_0()); 
            // InternalComputerDsl.g:4705:3: ( ruleQualifiedName )
            // InternalComputerDsl.g:4706:4: ruleQualifiedName
            {
             before(grammarAccess.getComputerAccess().getPeripheralsPeripheralQualifiedNameParserRuleCall_15_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getComputerAccess().getPeripheralsPeripheralQualifiedNameParserRuleCall_15_1_0_1()); 

            }

             after(grammarAccess.getComputerAccess().getPeripheralsPeripheralCrossReference_15_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__PeripheralsAssignment_15_1"


    // $ANTLR start "rule__Computer__PeripheralsAssignment_15_2_1"
    // InternalComputerDsl.g:4717:1: rule__Computer__PeripheralsAssignment_15_2_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Computer__PeripheralsAssignment_15_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4721:1: ( ( ( ruleQualifiedName ) ) )
            // InternalComputerDsl.g:4722:2: ( ( ruleQualifiedName ) )
            {
            // InternalComputerDsl.g:4722:2: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:4723:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getComputerAccess().getPeripheralsPeripheralCrossReference_15_2_1_0()); 
            // InternalComputerDsl.g:4724:3: ( ruleQualifiedName )
            // InternalComputerDsl.g:4725:4: ruleQualifiedName
            {
             before(grammarAccess.getComputerAccess().getPeripheralsPeripheralQualifiedNameParserRuleCall_15_2_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getComputerAccess().getPeripheralsPeripheralQualifiedNameParserRuleCall_15_2_1_0_1()); 

            }

             after(grammarAccess.getComputerAccess().getPeripheralsPeripheralCrossReference_15_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__PeripheralsAssignment_15_2_1"


    // $ANTLR start "rule__Computer__PowerSupplyAssignment_17"
    // InternalComputerDsl.g:4736:1: rule__Computer__PowerSupplyAssignment_17 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Computer__PowerSupplyAssignment_17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4740:1: ( ( ( ruleQualifiedName ) ) )
            // InternalComputerDsl.g:4741:2: ( ( ruleQualifiedName ) )
            {
            // InternalComputerDsl.g:4741:2: ( ( ruleQualifiedName ) )
            // InternalComputerDsl.g:4742:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getComputerAccess().getPowerSupplyPowerSupplyCrossReference_17_0()); 
            // InternalComputerDsl.g:4743:3: ( ruleQualifiedName )
            // InternalComputerDsl.g:4744:4: ruleQualifiedName
            {
             before(grammarAccess.getComputerAccess().getPowerSupplyPowerSupplyQualifiedNameParserRuleCall_17_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getComputerAccess().getPowerSupplyPowerSupplyQualifiedNameParserRuleCall_17_0_1()); 

            }

             after(grammarAccess.getComputerAccess().getPowerSupplyPowerSupplyCrossReference_17_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Computer__PowerSupplyAssignment_17"


    // $ANTLR start "rule__Motherboard__NameAssignment_1"
    // InternalComputerDsl.g:4755:1: rule__Motherboard__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Motherboard__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4759:1: ( ( RULE_ID ) )
            // InternalComputerDsl.g:4760:2: ( RULE_ID )
            {
            // InternalComputerDsl.g:4760:2: ( RULE_ID )
            // InternalComputerDsl.g:4761:3: RULE_ID
            {
             before(grammarAccess.getMotherboardAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMotherboardAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__NameAssignment_1"


    // $ANTLR start "rule__Motherboard__PowerAssignment_4"
    // InternalComputerDsl.g:4770:1: rule__Motherboard__PowerAssignment_4 : ( RULE_INT ) ;
    public final void rule__Motherboard__PowerAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4774:1: ( ( RULE_INT ) )
            // InternalComputerDsl.g:4775:2: ( RULE_INT )
            {
            // InternalComputerDsl.g:4775:2: ( RULE_INT )
            // InternalComputerDsl.g:4776:3: RULE_INT
            {
             before(grammarAccess.getMotherboardAccess().getPowerINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMotherboardAccess().getPowerINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__PowerAssignment_4"


    // $ANTLR start "rule__Motherboard__TypeAssignment_6"
    // InternalComputerDsl.g:4785:1: rule__Motherboard__TypeAssignment_6 : ( ruleMotherboardType ) ;
    public final void rule__Motherboard__TypeAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4789:1: ( ( ruleMotherboardType ) )
            // InternalComputerDsl.g:4790:2: ( ruleMotherboardType )
            {
            // InternalComputerDsl.g:4790:2: ( ruleMotherboardType )
            // InternalComputerDsl.g:4791:3: ruleMotherboardType
            {
             before(grammarAccess.getMotherboardAccess().getTypeMotherboardTypeEnumRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleMotherboardType();

            state._fsp--;

             after(grammarAccess.getMotherboardAccess().getTypeMotherboardTypeEnumRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__TypeAssignment_6"


    // $ANTLR start "rule__Motherboard__ChipsetAssignment_8"
    // InternalComputerDsl.g:4800:1: rule__Motherboard__ChipsetAssignment_8 : ( RULE_STRING ) ;
    public final void rule__Motherboard__ChipsetAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4804:1: ( ( RULE_STRING ) )
            // InternalComputerDsl.g:4805:2: ( RULE_STRING )
            {
            // InternalComputerDsl.g:4805:2: ( RULE_STRING )
            // InternalComputerDsl.g:4806:3: RULE_STRING
            {
             before(grammarAccess.getMotherboardAccess().getChipsetSTRINGTerminalRuleCall_8_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getMotherboardAccess().getChipsetSTRINGTerminalRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__ChipsetAssignment_8"


    // $ANTLR start "rule__Motherboard__SocketAssignment_10"
    // InternalComputerDsl.g:4815:1: rule__Motherboard__SocketAssignment_10 : ( ruleSocket ) ;
    public final void rule__Motherboard__SocketAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4819:1: ( ( ruleSocket ) )
            // InternalComputerDsl.g:4820:2: ( ruleSocket )
            {
            // InternalComputerDsl.g:4820:2: ( ruleSocket )
            // InternalComputerDsl.g:4821:3: ruleSocket
            {
             before(grammarAccess.getMotherboardAccess().getSocketSocketEnumRuleCall_10_0()); 
            pushFollow(FOLLOW_2);
            ruleSocket();

            state._fsp--;

             after(grammarAccess.getMotherboardAccess().getSocketSocketEnumRuleCall_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__SocketAssignment_10"


    // $ANTLR start "rule__Motherboard__PortsAssignment_11_1"
    // InternalComputerDsl.g:4830:1: rule__Motherboard__PortsAssignment_11_1 : ( rulePort ) ;
    public final void rule__Motherboard__PortsAssignment_11_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4834:1: ( ( rulePort ) )
            // InternalComputerDsl.g:4835:2: ( rulePort )
            {
            // InternalComputerDsl.g:4835:2: ( rulePort )
            // InternalComputerDsl.g:4836:3: rulePort
            {
             before(grammarAccess.getMotherboardAccess().getPortsPortEnumRuleCall_11_1_0()); 
            pushFollow(FOLLOW_2);
            rulePort();

            state._fsp--;

             after(grammarAccess.getMotherboardAccess().getPortsPortEnumRuleCall_11_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__PortsAssignment_11_1"


    // $ANTLR start "rule__Motherboard__PortsAssignment_11_2_1"
    // InternalComputerDsl.g:4845:1: rule__Motherboard__PortsAssignment_11_2_1 : ( rulePort ) ;
    public final void rule__Motherboard__PortsAssignment_11_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4849:1: ( ( rulePort ) )
            // InternalComputerDsl.g:4850:2: ( rulePort )
            {
            // InternalComputerDsl.g:4850:2: ( rulePort )
            // InternalComputerDsl.g:4851:3: rulePort
            {
             before(grammarAccess.getMotherboardAccess().getPortsPortEnumRuleCall_11_2_1_0()); 
            pushFollow(FOLLOW_2);
            rulePort();

            state._fsp--;

             after(grammarAccess.getMotherboardAccess().getPortsPortEnumRuleCall_11_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Motherboard__PortsAssignment_11_2_1"


    // $ANTLR start "rule__Processor__NameAssignment_1"
    // InternalComputerDsl.g:4860:1: rule__Processor__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Processor__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4864:1: ( ( RULE_ID ) )
            // InternalComputerDsl.g:4865:2: ( RULE_ID )
            {
            // InternalComputerDsl.g:4865:2: ( RULE_ID )
            // InternalComputerDsl.g:4866:3: RULE_ID
            {
             before(grammarAccess.getProcessorAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getProcessorAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__NameAssignment_1"


    // $ANTLR start "rule__Processor__PowerAssignment_4"
    // InternalComputerDsl.g:4875:1: rule__Processor__PowerAssignment_4 : ( RULE_INT ) ;
    public final void rule__Processor__PowerAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4879:1: ( ( RULE_INT ) )
            // InternalComputerDsl.g:4880:2: ( RULE_INT )
            {
            // InternalComputerDsl.g:4880:2: ( RULE_INT )
            // InternalComputerDsl.g:4881:3: RULE_INT
            {
             before(grammarAccess.getProcessorAccess().getPowerINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getProcessorAccess().getPowerINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__PowerAssignment_4"


    // $ANTLR start "rule__Processor__ModelAssignment_5_1"
    // InternalComputerDsl.g:4890:1: rule__Processor__ModelAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__Processor__ModelAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4894:1: ( ( RULE_STRING ) )
            // InternalComputerDsl.g:4895:2: ( RULE_STRING )
            {
            // InternalComputerDsl.g:4895:2: ( RULE_STRING )
            // InternalComputerDsl.g:4896:3: RULE_STRING
            {
             before(grammarAccess.getProcessorAccess().getModelSTRINGTerminalRuleCall_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getProcessorAccess().getModelSTRINGTerminalRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__ModelAssignment_5_1"


    // $ANTLR start "rule__Processor__SocketAssignment_7"
    // InternalComputerDsl.g:4905:1: rule__Processor__SocketAssignment_7 : ( ruleSocket ) ;
    public final void rule__Processor__SocketAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4909:1: ( ( ruleSocket ) )
            // InternalComputerDsl.g:4910:2: ( ruleSocket )
            {
            // InternalComputerDsl.g:4910:2: ( ruleSocket )
            // InternalComputerDsl.g:4911:3: ruleSocket
            {
             before(grammarAccess.getProcessorAccess().getSocketSocketEnumRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleSocket();

            state._fsp--;

             after(grammarAccess.getProcessorAccess().getSocketSocketEnumRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__SocketAssignment_7"


    // $ANTLR start "rule__Processor__CoresAssignment_9"
    // InternalComputerDsl.g:4920:1: rule__Processor__CoresAssignment_9 : ( RULE_INT ) ;
    public final void rule__Processor__CoresAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4924:1: ( ( RULE_INT ) )
            // InternalComputerDsl.g:4925:2: ( RULE_INT )
            {
            // InternalComputerDsl.g:4925:2: ( RULE_INT )
            // InternalComputerDsl.g:4926:3: RULE_INT
            {
             before(grammarAccess.getProcessorAccess().getCoresINTTerminalRuleCall_9_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getProcessorAccess().getCoresINTTerminalRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Processor__CoresAssignment_9"


    // $ANTLR start "rule__GraphicsCard__NameAssignment_1"
    // InternalComputerDsl.g:4935:1: rule__GraphicsCard__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__GraphicsCard__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4939:1: ( ( RULE_ID ) )
            // InternalComputerDsl.g:4940:2: ( RULE_ID )
            {
            // InternalComputerDsl.g:4940:2: ( RULE_ID )
            // InternalComputerDsl.g:4941:3: RULE_ID
            {
             before(grammarAccess.getGraphicsCardAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getGraphicsCardAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__NameAssignment_1"


    // $ANTLR start "rule__GraphicsCard__PowerAssignment_4"
    // InternalComputerDsl.g:4950:1: rule__GraphicsCard__PowerAssignment_4 : ( RULE_INT ) ;
    public final void rule__GraphicsCard__PowerAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4954:1: ( ( RULE_INT ) )
            // InternalComputerDsl.g:4955:2: ( RULE_INT )
            {
            // InternalComputerDsl.g:4955:2: ( RULE_INT )
            // InternalComputerDsl.g:4956:3: RULE_INT
            {
             before(grammarAccess.getGraphicsCardAccess().getPowerINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getGraphicsCardAccess().getPowerINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__PowerAssignment_4"


    // $ANTLR start "rule__GraphicsCard__ModelAssignment_5_1"
    // InternalComputerDsl.g:4965:1: rule__GraphicsCard__ModelAssignment_5_1 : ( RULE_STRING ) ;
    public final void rule__GraphicsCard__ModelAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4969:1: ( ( RULE_STRING ) )
            // InternalComputerDsl.g:4970:2: ( RULE_STRING )
            {
            // InternalComputerDsl.g:4970:2: ( RULE_STRING )
            // InternalComputerDsl.g:4971:3: RULE_STRING
            {
             before(grammarAccess.getGraphicsCardAccess().getModelSTRINGTerminalRuleCall_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getGraphicsCardAccess().getModelSTRINGTerminalRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__ModelAssignment_5_1"


    // $ANTLR start "rule__GraphicsCard__VramAssignment_7"
    // InternalComputerDsl.g:4980:1: rule__GraphicsCard__VramAssignment_7 : ( RULE_INT ) ;
    public final void rule__GraphicsCard__VramAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4984:1: ( ( RULE_INT ) )
            // InternalComputerDsl.g:4985:2: ( RULE_INT )
            {
            // InternalComputerDsl.g:4985:2: ( RULE_INT )
            // InternalComputerDsl.g:4986:3: RULE_INT
            {
             before(grammarAccess.getGraphicsCardAccess().getVramINTTerminalRuleCall_7_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getGraphicsCardAccess().getVramINTTerminalRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__GraphicsCard__VramAssignment_7"


    // $ANTLR start "rule__Memory__NameAssignment_1"
    // InternalComputerDsl.g:4995:1: rule__Memory__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Memory__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:4999:1: ( ( RULE_ID ) )
            // InternalComputerDsl.g:5000:2: ( RULE_ID )
            {
            // InternalComputerDsl.g:5000:2: ( RULE_ID )
            // InternalComputerDsl.g:5001:3: RULE_ID
            {
             before(grammarAccess.getMemoryAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMemoryAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__NameAssignment_1"


    // $ANTLR start "rule__Memory__PowerAssignment_4"
    // InternalComputerDsl.g:5010:1: rule__Memory__PowerAssignment_4 : ( RULE_INT ) ;
    public final void rule__Memory__PowerAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5014:1: ( ( RULE_INT ) )
            // InternalComputerDsl.g:5015:2: ( RULE_INT )
            {
            // InternalComputerDsl.g:5015:2: ( RULE_INT )
            // InternalComputerDsl.g:5016:3: RULE_INT
            {
             before(grammarAccess.getMemoryAccess().getPowerINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMemoryAccess().getPowerINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__PowerAssignment_4"


    // $ANTLR start "rule__Memory__TypeAssignment_6"
    // InternalComputerDsl.g:5025:1: rule__Memory__TypeAssignment_6 : ( ruleMemoryType ) ;
    public final void rule__Memory__TypeAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5029:1: ( ( ruleMemoryType ) )
            // InternalComputerDsl.g:5030:2: ( ruleMemoryType )
            {
            // InternalComputerDsl.g:5030:2: ( ruleMemoryType )
            // InternalComputerDsl.g:5031:3: ruleMemoryType
            {
             before(grammarAccess.getMemoryAccess().getTypeMemoryTypeEnumRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleMemoryType();

            state._fsp--;

             after(grammarAccess.getMemoryAccess().getTypeMemoryTypeEnumRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__TypeAssignment_6"


    // $ANTLR start "rule__Memory__CapacityAssignment_8"
    // InternalComputerDsl.g:5040:1: rule__Memory__CapacityAssignment_8 : ( RULE_INT ) ;
    public final void rule__Memory__CapacityAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5044:1: ( ( RULE_INT ) )
            // InternalComputerDsl.g:5045:2: ( RULE_INT )
            {
            // InternalComputerDsl.g:5045:2: ( RULE_INT )
            // InternalComputerDsl.g:5046:3: RULE_INT
            {
             before(grammarAccess.getMemoryAccess().getCapacityINTTerminalRuleCall_8_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getMemoryAccess().getCapacityINTTerminalRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Memory__CapacityAssignment_8"


    // $ANTLR start "rule__Storage__NameAssignment_1"
    // InternalComputerDsl.g:5055:1: rule__Storage__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Storage__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5059:1: ( ( RULE_ID ) )
            // InternalComputerDsl.g:5060:2: ( RULE_ID )
            {
            // InternalComputerDsl.g:5060:2: ( RULE_ID )
            // InternalComputerDsl.g:5061:3: RULE_ID
            {
             before(grammarAccess.getStorageAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getStorageAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__NameAssignment_1"


    // $ANTLR start "rule__Storage__PowerAssignment_4"
    // InternalComputerDsl.g:5070:1: rule__Storage__PowerAssignment_4 : ( RULE_INT ) ;
    public final void rule__Storage__PowerAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5074:1: ( ( RULE_INT ) )
            // InternalComputerDsl.g:5075:2: ( RULE_INT )
            {
            // InternalComputerDsl.g:5075:2: ( RULE_INT )
            // InternalComputerDsl.g:5076:3: RULE_INT
            {
             before(grammarAccess.getStorageAccess().getPowerINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getStorageAccess().getPowerINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__PowerAssignment_4"


    // $ANTLR start "rule__Storage__TypeAssignment_6"
    // InternalComputerDsl.g:5085:1: rule__Storage__TypeAssignment_6 : ( ruleStorageType ) ;
    public final void rule__Storage__TypeAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5089:1: ( ( ruleStorageType ) )
            // InternalComputerDsl.g:5090:2: ( ruleStorageType )
            {
            // InternalComputerDsl.g:5090:2: ( ruleStorageType )
            // InternalComputerDsl.g:5091:3: ruleStorageType
            {
             before(grammarAccess.getStorageAccess().getTypeStorageTypeEnumRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleStorageType();

            state._fsp--;

             after(grammarAccess.getStorageAccess().getTypeStorageTypeEnumRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__TypeAssignment_6"


    // $ANTLR start "rule__Storage__CapacityAssignment_8"
    // InternalComputerDsl.g:5100:1: rule__Storage__CapacityAssignment_8 : ( RULE_INT ) ;
    public final void rule__Storage__CapacityAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5104:1: ( ( RULE_INT ) )
            // InternalComputerDsl.g:5105:2: ( RULE_INT )
            {
            // InternalComputerDsl.g:5105:2: ( RULE_INT )
            // InternalComputerDsl.g:5106:3: RULE_INT
            {
             before(grammarAccess.getStorageAccess().getCapacityINTTerminalRuleCall_8_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getStorageAccess().getCapacityINTTerminalRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Storage__CapacityAssignment_8"


    // $ANTLR start "rule__Drive__NameAssignment_1"
    // InternalComputerDsl.g:5115:1: rule__Drive__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Drive__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5119:1: ( ( RULE_ID ) )
            // InternalComputerDsl.g:5120:2: ( RULE_ID )
            {
            // InternalComputerDsl.g:5120:2: ( RULE_ID )
            // InternalComputerDsl.g:5121:3: RULE_ID
            {
             before(grammarAccess.getDriveAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDriveAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__NameAssignment_1"


    // $ANTLR start "rule__Drive__PowerAssignment_4"
    // InternalComputerDsl.g:5130:1: rule__Drive__PowerAssignment_4 : ( RULE_INT ) ;
    public final void rule__Drive__PowerAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5134:1: ( ( RULE_INT ) )
            // InternalComputerDsl.g:5135:2: ( RULE_INT )
            {
            // InternalComputerDsl.g:5135:2: ( RULE_INT )
            // InternalComputerDsl.g:5136:3: RULE_INT
            {
             before(grammarAccess.getDriveAccess().getPowerINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getDriveAccess().getPowerINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__PowerAssignment_4"


    // $ANTLR start "rule__Drive__TypeAssignment_6"
    // InternalComputerDsl.g:5145:1: rule__Drive__TypeAssignment_6 : ( ruleDriveType ) ;
    public final void rule__Drive__TypeAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5149:1: ( ( ruleDriveType ) )
            // InternalComputerDsl.g:5150:2: ( ruleDriveType )
            {
            // InternalComputerDsl.g:5150:2: ( ruleDriveType )
            // InternalComputerDsl.g:5151:3: ruleDriveType
            {
             before(grammarAccess.getDriveAccess().getTypeDriveTypeEnumRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleDriveType();

            state._fsp--;

             after(grammarAccess.getDriveAccess().getTypeDriveTypeEnumRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Drive__TypeAssignment_6"


    // $ANTLR start "rule__Peripheral__KindAssignment_0"
    // InternalComputerDsl.g:5160:1: rule__Peripheral__KindAssignment_0 : ( rulePeripheralKind ) ;
    public final void rule__Peripheral__KindAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5164:1: ( ( rulePeripheralKind ) )
            // InternalComputerDsl.g:5165:2: ( rulePeripheralKind )
            {
            // InternalComputerDsl.g:5165:2: ( rulePeripheralKind )
            // InternalComputerDsl.g:5166:3: rulePeripheralKind
            {
             before(grammarAccess.getPeripheralAccess().getKindPeripheralKindEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            rulePeripheralKind();

            state._fsp--;

             after(grammarAccess.getPeripheralAccess().getKindPeripheralKindEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__KindAssignment_0"


    // $ANTLR start "rule__Peripheral__NameAssignment_1"
    // InternalComputerDsl.g:5175:1: rule__Peripheral__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Peripheral__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5179:1: ( ( RULE_ID ) )
            // InternalComputerDsl.g:5180:2: ( RULE_ID )
            {
            // InternalComputerDsl.g:5180:2: ( RULE_ID )
            // InternalComputerDsl.g:5181:3: RULE_ID
            {
             before(grammarAccess.getPeripheralAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPeripheralAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__NameAssignment_1"


    // $ANTLR start "rule__Peripheral__PowerAssignment_4"
    // InternalComputerDsl.g:5190:1: rule__Peripheral__PowerAssignment_4 : ( RULE_INT ) ;
    public final void rule__Peripheral__PowerAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5194:1: ( ( RULE_INT ) )
            // InternalComputerDsl.g:5195:2: ( RULE_INT )
            {
            // InternalComputerDsl.g:5195:2: ( RULE_INT )
            // InternalComputerDsl.g:5196:3: RULE_INT
            {
             before(grammarAccess.getPeripheralAccess().getPowerINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPeripheralAccess().getPowerINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__PowerAssignment_4"


    // $ANTLR start "rule__Peripheral__PortAssignment_6"
    // InternalComputerDsl.g:5205:1: rule__Peripheral__PortAssignment_6 : ( rulePort ) ;
    public final void rule__Peripheral__PortAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5209:1: ( ( rulePort ) )
            // InternalComputerDsl.g:5210:2: ( rulePort )
            {
            // InternalComputerDsl.g:5210:2: ( rulePort )
            // InternalComputerDsl.g:5211:3: rulePort
            {
             before(grammarAccess.getPeripheralAccess().getPortPortEnumRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            rulePort();

            state._fsp--;

             after(grammarAccess.getPeripheralAccess().getPortPortEnumRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Peripheral__PortAssignment_6"


    // $ANTLR start "rule__PowerSupply__NameAssignment_1"
    // InternalComputerDsl.g:5220:1: rule__PowerSupply__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__PowerSupply__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5224:1: ( ( RULE_ID ) )
            // InternalComputerDsl.g:5225:2: ( RULE_ID )
            {
            // InternalComputerDsl.g:5225:2: ( RULE_ID )
            // InternalComputerDsl.g:5226:3: RULE_ID
            {
             before(grammarAccess.getPowerSupplyAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPowerSupplyAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__NameAssignment_1"


    // $ANTLR start "rule__PowerSupply__CapacityAssignment_4"
    // InternalComputerDsl.g:5235:1: rule__PowerSupply__CapacityAssignment_4 : ( RULE_INT ) ;
    public final void rule__PowerSupply__CapacityAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5239:1: ( ( RULE_INT ) )
            // InternalComputerDsl.g:5240:2: ( RULE_INT )
            {
            // InternalComputerDsl.g:5240:2: ( RULE_INT )
            // InternalComputerDsl.g:5241:3: RULE_INT
            {
             before(grammarAccess.getPowerSupplyAccess().getCapacityINTTerminalRuleCall_4_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getPowerSupplyAccess().getCapacityINTTerminalRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__CapacityAssignment_4"


    // $ANTLR start "rule__PowerSupply__RatingAssignment_6"
    // InternalComputerDsl.g:5250:1: rule__PowerSupply__RatingAssignment_6 : ( ruleRating ) ;
    public final void rule__PowerSupply__RatingAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalComputerDsl.g:5254:1: ( ( ruleRating ) )
            // InternalComputerDsl.g:5255:2: ( ruleRating )
            {
            // InternalComputerDsl.g:5255:2: ( ruleRating )
            // InternalComputerDsl.g:5256:3: ruleRating
            {
             before(grammarAccess.getPowerSupplyAccess().getRatingRatingEnumRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleRating();

            state._fsp--;

             after(grammarAccess.getPowerSupplyAccess().getRatingRatingEnumRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PowerSupply__RatingAssignment_6"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x02FE480000007802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x02FE680000007800L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0090000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0120000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0740000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00000000003C0000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x8000200000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000000001FC00000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000003E00000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x000007C000000000L});

}