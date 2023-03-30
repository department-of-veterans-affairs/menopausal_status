
/* First created by JCasGen Thu Sep 30 14:13:55 CDT 2021 */
package gov.va.vinci.menopause.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType_Type;

/** 
 * Updated by JCasGen Thu Sep 30 14:13:55 CDT 2021
 * @generated */
public class LastMenstrualDate_Type extends AnnotationPatternType_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = LastMenstrualDate.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("gov.va.vinci.menopause.types.LastMenstrualDate");
 
  /** @generated */
  final Feature casFeat_Concept;
  /** @generated */
  final int     casFeatCode_Concept;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getConcept(int addr) {
        if (featOkTst && casFeat_Concept == null)
      jcas.throwFeatMissing("Concept", "gov.va.vinci.menopause.types.LastMenstrualDate");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Concept);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setConcept(int addr, String v) {
        if (featOkTst && casFeat_Concept == null)
      jcas.throwFeatMissing("Concept", "gov.va.vinci.menopause.types.LastMenstrualDate");
    ll_cas.ll_setStringValue(addr, casFeatCode_Concept, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Date;
  /** @generated */
  final int     casFeatCode_Date;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getDate(int addr) {
        if (featOkTst && casFeat_Date == null)
      jcas.throwFeatMissing("Date", "gov.va.vinci.menopause.types.LastMenstrualDate");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Date);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDate(int addr, String v) {
        if (featOkTst && casFeat_Date == null)
      jcas.throwFeatMissing("Date", "gov.va.vinci.menopause.types.LastMenstrualDate");
    ll_cas.ll_setStringValue(addr, casFeatCode_Date, v);}
    
  
 
  /** @generated */
  final Feature casFeat_RelativeQty;
  /** @generated */
  final int     casFeatCode_RelativeQty;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getRelativeQty(int addr) {
        if (featOkTst && casFeat_RelativeQty == null)
      jcas.throwFeatMissing("RelativeQty", "gov.va.vinci.menopause.types.LastMenstrualDate");
    return ll_cas.ll_getStringValue(addr, casFeatCode_RelativeQty);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRelativeQty(int addr, String v) {
        if (featOkTst && casFeat_RelativeQty == null)
      jcas.throwFeatMissing("RelativeQty", "gov.va.vinci.menopause.types.LastMenstrualDate");
    ll_cas.ll_setStringValue(addr, casFeatCode_RelativeQty, v);}
    
  
 
  /** @generated */
  final Feature casFeat_RelativeUnit;
  /** @generated */
  final int     casFeatCode_RelativeUnit;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getRelativeUnit(int addr) {
        if (featOkTst && casFeat_RelativeUnit == null)
      jcas.throwFeatMissing("RelativeUnit", "gov.va.vinci.menopause.types.LastMenstrualDate");
    return ll_cas.ll_getStringValue(addr, casFeatCode_RelativeUnit);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRelativeUnit(int addr, String v) {
        if (featOkTst && casFeat_RelativeUnit == null)
      jcas.throwFeatMissing("RelativeUnit", "gov.va.vinci.menopause.types.LastMenstrualDate");
    ll_cas.ll_setStringValue(addr, casFeatCode_RelativeUnit, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public LastMenstrualDate_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Concept = jcas.getRequiredFeatureDE(casType, "Concept", "uima.cas.String", featOkTst);
    casFeatCode_Concept  = (null == casFeat_Concept) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Concept).getCode();

 
    casFeat_Date = jcas.getRequiredFeatureDE(casType, "Date", "uima.cas.String", featOkTst);
    casFeatCode_Date  = (null == casFeat_Date) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Date).getCode();

 
    casFeat_RelativeQty = jcas.getRequiredFeatureDE(casType, "RelativeQty", "uima.cas.String", featOkTst);
    casFeatCode_RelativeQty  = (null == casFeat_RelativeQty) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_RelativeQty).getCode();

 
    casFeat_RelativeUnit = jcas.getRequiredFeatureDE(casType, "RelativeUnit", "uima.cas.String", featOkTst);
    casFeatCode_RelativeUnit  = (null == casFeat_RelativeUnit) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_RelativeUnit).getCode();

  }
}



    