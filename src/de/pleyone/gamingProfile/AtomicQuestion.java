package de.pleyone.gamingProfile;

import java.util.ArrayList;

/**
 * @author son87.lengoc@yahoo.de
 *         Created: 09.03.11 at 20:39
 */
public class AtomicQuestion implements Question{
  private boolean isSingleValue;
  private AnswerType answerType;
  public String description;
  private String keyword;
  public boolean indexed = false;

  public AtomicQuestion(boolean isSingleValue, AnswerType answerType, String keyword){
    this.isSingleValue = isSingleValue;
    this.answerType = answerType;
    this.keyword = keyword;
  }

  
  public boolean isSingleValue(){
    return isSingleValue;
  }

  public AnswerType getAnswerType(){
    return answerType ;
  }

  public String getKeyword(){
    return keyword;
  }

  public String getNumberOfAnswer(){
    return isSingleValue()?"single_value":"multi_value";
  }

  public boolean isAtomic(){
    return true;
  }

  public boolean isComplex(){
    return false;
  }

}
