
/* First created by JCasGen Thu Sep 30 14:13:55 CDT 2021 */
package gov.va.vinci.leo.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Thu Sep 30 14:13:55 CDT 2021
 * @generated */
public class ParsedDate_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = ParsedDate.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("gov.va.vinci.leo.types.ParsedDate");
 
  /** @generated */
  final Feature casFeat_Date1;
  /** @generated */
  final int     casFeatCode_Date1;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getDate1(int addr) {
        if (featOkTst && casFeat_Date1 == null)
      jcas.throwFeatMissing("Date1", "gov.va.vinci.leo.types.ParsedDate");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Date1);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDate1(int addr, String v) {
        if (featOkTst && casFeat_Date1 == null)
      jcas.throwFeatMissing("Date1", "gov.va.vinci.leo.types.ParsedDate");
    ll_cas.ll_setStringValue(addr, casFeatCode_Date1, v);}
    
  
 
  /** @generated */
  final Feature casFeat_Date2;
  /** @generated */
  final int     casFeatCode_Date2;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getDate2(int addr) {
        if (featOkTst && casFeat_Date2 == null)
      jcas.throwFeatMissing("Date2", "gov.va.vinci.leo.types.ParsedDate");
    return ll_cas.ll_getStringValue(addr, casFeatCode_Date2);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setDate2(int addr, String v) {
        if (featOkTst && casFeat_Date2 == null)
      jcas.throwFeatMissing("Date2", "gov.va.vinci.leo.types.ParsedDate");
    ll_cas.ll_setStringValue(addr, casFeatCode_Date2, v);}
    
  
 
  /** @generated */
  final Feature casFeat_RelativeQuantity;
  /** @generated */
  final int     casFeatCode_RelativeQuantity;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getRelativeQuantity(int addr) {
        if (featOkTst && casFeat_RelativeQuantity == null)
      jcas.throwFeatMissing("RelativeQuantity", "gov.va.vinci.leo.types.ParsedDate");
    return ll_cas.ll_getStringValue(addr, casFeatCode_RelativeQuantity);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRelativeQuantity(int addr, String v) {
        if (featOkTst && casFeat_RelativeQuantity == null)
      jcas.throwFeatMissing("RelativeQuantity", "gov.va.vinci.leo.types.ParsedDate");
    ll_cas.ll_setStringValue(addr, casFeatCode_RelativeQuantity, v);}
    
  
 
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
      jcas.throwFeatMissing("RelativeUnit", "gov.va.vinci.leo.types.ParsedDate");
    return ll_cas.ll_getStringValue(addr, casFeatCode_RelativeUnit);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setRelativeUnit(int addr, String v) {
        if (featOkTst && casFeat_RelativeUnit == null)
      jcas.throwFeatMissing("RelativeUnit", "gov.va.vinci.leo.types.ParsedDate");
    ll_cas.ll_setStringValue(addr, casFeatCode_RelativeUnit, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public ParsedDate_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_Date1 = jcas.getRequiredFeatureDE(casType, "Date1", "uima.cas.String", featOkTst);
    casFeatCode_Date1  = (null == casFeat_Date1) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Date1).getCode();

 
    casFeat_Date2 = jcas.getRequiredFeatureDE(casType, "Date2", "uima.cas.String", featOkTst);
    casFeatCode_Date2  = (null == casFeat_Date2) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_Date2).getCode();

 
    casFeat_RelativeQuantity = jcas.getRequiredFeatureDE(casType, "RelativeQuantity", "uima.cas.String", featOkTst);
    casFeatCode_RelativeQuantity  = (null == casFeat_RelativeQuantity) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_RelativeQuantity).getCode();

 
    casFeat_RelativeUnit = jcas.getRequiredFeatureDE(casType, "RelativeUnit", "uima.cas.String", featOkTst);
    casFeatCode_RelativeUnit  = (null == casFeat_RelativeUnit) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_RelativeUnit).getCode();

  }
}



    