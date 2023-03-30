
/* First created by JCasGen Thu Sep 30 14:13:55 CDT 2021 */
package gov.va.vinci.menopause.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import gov.va.vinci.leo.regex.types.RegularExpressionType_Type;

/** 
 * Updated by JCasGen Thu Sep 30 14:13:55 CDT 2021
 * @generated */
public class NaturalMenopause_Type extends RegularExpressionType_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = NaturalMenopause.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("gov.va.vinci.menopause.types.NaturalMenopause");
 
  /** @generated */
  final Feature casFeat_Laterality;
  /** @generated */
  final int     casFeatCode_Laterality;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getLaterality(int addr) {
        if (featOkTst && casFeat_Laterality == null)
      jcas.throwFeatMissing("Laterality", "gov.va.vinci.menopause.types.NaturalMenopause");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Laterality);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setLaterality(int addr, String v) {
        if (featOkTst && casFeat_Laterality == null)
      jcas.throwFeatMissing("Laterality", "gov.va.vinci.menopause.types.NaturalMenopause");
    ll_cas.ll_setStringValue(addr, casFeatCode_Laterality, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public NaturalMenopause_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Laterality = jcas.getRequiredFeatureDE(casType, "Laterality", "uima.cas.String", featOkTst);
    casFeatCode_Laterality  = (null == casFeat_Laterality) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Laterality).getCode();

  }
}



    