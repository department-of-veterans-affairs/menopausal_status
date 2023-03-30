

/* First created by JCasGen Thu Sep 30 14:13:55 CDT 2021 */
package gov.va.vinci.menopause.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import gov.va.vinci.leo.annotationpattern.types.AnnotationPatternType;


/** 
 * Updated by JCasGen Thu Sep 30 14:13:55 CDT 2021
 * XML source: C:/Users/VHASLC~4/AppData/Local/Temp/3/leoTypeDescription_3451f15c-0aef-4127-b9b4-5b7824b370132826002547059396729.xml
 * @generated */
public class SurgicalMenopauseList extends AnnotationPatternType {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(SurgicalMenopauseList.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected SurgicalMenopauseList() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public SurgicalMenopauseList(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public SurgicalMenopauseList(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public SurgicalMenopauseList(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: Concept

  /** getter for Concept - gets 
   * @generated
   * @return value of the feature 
   */
  public String getConcept() {
    if (SurgicalMenopauseList_Type.featOkTst && ((SurgicalMenopauseList_Type)jcasType).casFeat_Concept == null)
      jcasType.jcas.throwFeatMissing("Concept", "gov.va.vinci.menopause.types.SurgicalMenopauseList");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SurgicalMenopauseList_Type)jcasType).casFeatCode_Concept);}
    
  /** setter for Concept - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setConcept(String v) {
    if (SurgicalMenopauseList_Type.featOkTst && ((SurgicalMenopauseList_Type)jcasType).casFeat_Concept == null)
      jcasType.jcas.throwFeatMissing("Concept", "gov.va.vinci.menopause.types.SurgicalMenopauseList");
    jcasType.ll_cas.ll_setStringValue(addr, ((SurgicalMenopauseList_Type)jcasType).casFeatCode_Concept, v);}    
   
    
  //*--------------*
  //* Feature: Date

  /** getter for Date - gets 
   * @generated
   * @return value of the feature 
   */
  public String getDate() {
    if (SurgicalMenopauseList_Type.featOkTst && ((SurgicalMenopauseList_Type)jcasType).casFeat_Date == null)
      jcasType.jcas.throwFeatMissing("Date", "gov.va.vinci.menopause.types.SurgicalMenopauseList");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SurgicalMenopauseList_Type)jcasType).casFeatCode_Date);}
    
  /** setter for Date - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setDate(String v) {
    if (SurgicalMenopauseList_Type.featOkTst && ((SurgicalMenopauseList_Type)jcasType).casFeat_Date == null)
      jcasType.jcas.throwFeatMissing("Date", "gov.va.vinci.menopause.types.SurgicalMenopauseList");
    jcasType.ll_cas.ll_setStringValue(addr, ((SurgicalMenopauseList_Type)jcasType).casFeatCode_Date, v);}    
   
    
  //*--------------*
  //* Feature: RelativeQty

  /** getter for RelativeQty - gets 
   * @generated
   * @return value of the feature 
   */
  public String getRelativeQty() {
    if (SurgicalMenopauseList_Type.featOkTst && ((SurgicalMenopauseList_Type)jcasType).casFeat_RelativeQty == null)
      jcasType.jcas.throwFeatMissing("RelativeQty", "gov.va.vinci.menopause.types.SurgicalMenopauseList");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SurgicalMenopauseList_Type)jcasType).casFeatCode_RelativeQty);}
    
  /** setter for RelativeQty - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setRelativeQty(String v) {
    if (SurgicalMenopauseList_Type.featOkTst && ((SurgicalMenopauseList_Type)jcasType).casFeat_RelativeQty == null)
      jcasType.jcas.throwFeatMissing("RelativeQty", "gov.va.vinci.menopause.types.SurgicalMenopauseList");
    jcasType.ll_cas.ll_setStringValue(addr, ((SurgicalMenopauseList_Type)jcasType).casFeatCode_RelativeQty, v);}    
   
    
  //*--------------*
  //* Feature: RelativeUnit

  /** getter for RelativeUnit - gets 
   * @generated
   * @return value of the feature 
   */
  public String getRelativeUnit() {
    if (SurgicalMenopauseList_Type.featOkTst && ((SurgicalMenopauseList_Type)jcasType).casFeat_RelativeUnit == null)
      jcasType.jcas.throwFeatMissing("RelativeUnit", "gov.va.vinci.menopause.types.SurgicalMenopauseList");
    return jcasType.ll_cas.ll_getStringValue(addr, ((SurgicalMenopauseList_Type)jcasType).casFeatCode_RelativeUnit);}
    
  /** setter for RelativeUnit - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setRelativeUnit(String v) {
    if (SurgicalMenopauseList_Type.featOkTst && ((SurgicalMenopauseList_Type)jcasType).casFeat_RelativeUnit == null)
      jcasType.jcas.throwFeatMissing("RelativeUnit", "gov.va.vinci.menopause.types.SurgicalMenopauseList");
    jcasType.ll_cas.ll_setStringValue(addr, ((SurgicalMenopauseList_Type)jcasType).casFeatCode_RelativeUnit, v);}    
  }

    