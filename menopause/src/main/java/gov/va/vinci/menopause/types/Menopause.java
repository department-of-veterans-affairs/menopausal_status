

/* First created by JCasGen Thu Sep 30 14:13:55 CDT 2021 */
package gov.va.vinci.menopause.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import gov.va.vinci.leo.regex.types.RegularExpressionType;


/** 
 * Updated by JCasGen Thu Sep 30 14:13:55 CDT 2021
 * XML source: C:/Users/VHASLC~4/AppData/Local/Temp/3/leoTypeDescription_3451f15c-0aef-4127-b9b4-5b7824b370132826002547059396729.xml
 * @generated */
public class Menopause extends RegularExpressionType {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Menopause.class);
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
  protected Menopause() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Menopause(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Menopause(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Menopause(JCas jcas, int begin, int end) {
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
  //* Feature: Laterality

  /** getter for Laterality - gets 
   * @generated
   * @return value of the feature 
   */
  public String getLaterality() {
    if (Menopause_Type.featOkTst && ((Menopause_Type)jcasType).casFeat_Laterality == null)
      jcasType.jcas.throwFeatMissing("Laterality", "gov.va.vinci.menopause.types.Menopause");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Menopause_Type)jcasType).casFeatCode_Laterality);}
    
  /** setter for Laterality - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setLaterality(String v) {
    if (Menopause_Type.featOkTst && ((Menopause_Type)jcasType).casFeat_Laterality == null)
      jcasType.jcas.throwFeatMissing("Laterality", "gov.va.vinci.menopause.types.Menopause");
    jcasType.ll_cas.ll_setStringValue(addr, ((Menopause_Type)jcasType).casFeatCode_Laterality, v);}    
  }

    