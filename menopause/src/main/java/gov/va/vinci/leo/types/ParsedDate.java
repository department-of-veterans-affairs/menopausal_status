

/* First created by JCasGen Thu Sep 30 14:13:55 CDT 2021 */
package gov.va.vinci.leo.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Thu Sep 30 14:13:55 CDT 2021
 * XML source: C:/Users/VHASLC~4/AppData/Local/Temp/3/leoTypeDescription_3451f15c-0aef-4127-b9b4-5b7824b370132826002547059396729.xml
 * @generated */
public class ParsedDate extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(ParsedDate.class);
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
  protected ParsedDate() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public ParsedDate(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public ParsedDate(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public ParsedDate(JCas jcas, int begin, int end) {
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
  //* Feature: Date1

  /** getter for Date1 - gets Parsed Date
   * @generated
   * @return value of the feature 
   */
  public String getDate1() {
    if (ParsedDate_Type.featOkTst && ((ParsedDate_Type)jcasType).casFeat_Date1 == null)
      jcasType.jcas.throwFeatMissing("Date1", "gov.va.vinci.leo.types.ParsedDate");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ParsedDate_Type)jcasType).casFeatCode_Date1);}
    
  /** setter for Date1 - sets Parsed Date 
   * @generated
   * @param v value to set into the feature 
   */
  public void setDate1(String v) {
    if (ParsedDate_Type.featOkTst && ((ParsedDate_Type)jcasType).casFeat_Date1 == null)
      jcasType.jcas.throwFeatMissing("Date1", "gov.va.vinci.leo.types.ParsedDate");
    jcasType.ll_cas.ll_setStringValue(addr, ((ParsedDate_Type)jcasType).casFeatCode_Date1, v);}    
   
    
  //*--------------*
  //* Feature: Date2

  /** getter for Date2 - gets Parsed Date (if range)
   * @generated
   * @return value of the feature 
   */
  public String getDate2() {
    if (ParsedDate_Type.featOkTst && ((ParsedDate_Type)jcasType).casFeat_Date2 == null)
      jcasType.jcas.throwFeatMissing("Date2", "gov.va.vinci.leo.types.ParsedDate");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ParsedDate_Type)jcasType).casFeatCode_Date2);}
    
  /** setter for Date2 - sets Parsed Date (if range) 
   * @generated
   * @param v value to set into the feature 
   */
  public void setDate2(String v) {
    if (ParsedDate_Type.featOkTst && ((ParsedDate_Type)jcasType).casFeat_Date2 == null)
      jcasType.jcas.throwFeatMissing("Date2", "gov.va.vinci.leo.types.ParsedDate");
    jcasType.ll_cas.ll_setStringValue(addr, ((ParsedDate_Type)jcasType).casFeatCode_Date2, v);}    
   
    
  //*--------------*
  //* Feature: RelativeQuantity

  /** getter for RelativeQuantity - gets Part of relative date
   * @generated
   * @return value of the feature 
   */
  public String getRelativeQuantity() {
    if (ParsedDate_Type.featOkTst && ((ParsedDate_Type)jcasType).casFeat_RelativeQuantity == null)
      jcasType.jcas.throwFeatMissing("RelativeQuantity", "gov.va.vinci.leo.types.ParsedDate");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ParsedDate_Type)jcasType).casFeatCode_RelativeQuantity);}
    
  /** setter for RelativeQuantity - sets Part of relative date 
   * @generated
   * @param v value to set into the feature 
   */
  public void setRelativeQuantity(String v) {
    if (ParsedDate_Type.featOkTst && ((ParsedDate_Type)jcasType).casFeat_RelativeQuantity == null)
      jcasType.jcas.throwFeatMissing("RelativeQuantity", "gov.va.vinci.leo.types.ParsedDate");
    jcasType.ll_cas.ll_setStringValue(addr, ((ParsedDate_Type)jcasType).casFeatCode_RelativeQuantity, v);}    
   
    
  //*--------------*
  //* Feature: RelativeUnit

  /** getter for RelativeUnit - gets Part of relative date
   * @generated
   * @return value of the feature 
   */
  public String getRelativeUnit() {
    if (ParsedDate_Type.featOkTst && ((ParsedDate_Type)jcasType).casFeat_RelativeUnit == null)
      jcasType.jcas.throwFeatMissing("RelativeUnit", "gov.va.vinci.leo.types.ParsedDate");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ParsedDate_Type)jcasType).casFeatCode_RelativeUnit);}
    
  /** setter for RelativeUnit - sets Part of relative date 
   * @generated
   * @param v value to set into the feature 
   */
  public void setRelativeUnit(String v) {
    if (ParsedDate_Type.featOkTst && ((ParsedDate_Type)jcasType).casFeat_RelativeUnit == null)
      jcasType.jcas.throwFeatMissing("RelativeUnit", "gov.va.vinci.leo.types.ParsedDate");
    jcasType.ll_cas.ll_setStringValue(addr, ((ParsedDate_Type)jcasType).casFeatCode_RelativeUnit, v);}    
  }

    