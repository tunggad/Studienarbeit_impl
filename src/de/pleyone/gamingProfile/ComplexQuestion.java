package de.pleyone.gamingProfile;

import java.sql.Array;
import java.util.ArrayList;

/**
 * @author son87.lengoc@yahoo.de
 *         Created: 10.03.11 at 17:52
 */
public class ComplexQuestion implements Question{
  private ArrayList<Question> subQuestions;
  public String description;
  private String keyword;

  public ComplexQuestion(String keyword){
    this.keyword = keyword;
  }

  public ArrayList<Question> getSubQuestions(){
    return subQuestions;
  }

   public void setSubQuestions(ArrayList<Question> subQuestions){
     this.subQuestions = subQuestions;
  }

  public String getKeyword(){
    return keyword;
  }

  public boolean isAtomic(){
    return false;
  }

  public boolean isComplex(){
    return true;
  }

}
