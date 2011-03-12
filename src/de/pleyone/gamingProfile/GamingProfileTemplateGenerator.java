package de.pleyone.gamingProfile;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author son87.lengoc@yahoo.de
 *         Created: 10.03.11 at 18:19
 */
public class GamingProfileTemplateGenerator {
  private static Random randomGenerator = new Random();

  public static GamingProfileTemplate generateOneGamingProfileTemplate(){
    GamingProfileTemplate gamingProfileTemplate = new GamingProfileTemplate();
    int nestingLevel = randomGenerator.nextInt(3);
    ArrayList<Question> questions = generateListOfQuestions(nestingLevel,5);
    gamingProfileTemplate.questions = questions;

    return gamingProfileTemplate;
  }

  public static AtomicQuestion generateOneAtomicQuestion(String keyword, String description){
    boolean singleValue = (randomGenerator.nextInt(10) < 5)?true:false; // 50% singleValue
    AnswerType answerType = (randomGenerator.nextInt(10) < 5)?AnswerType.NUMBER:AnswerType.STRING; // 50% NUMBER
    AtomicQuestion atomicQuestion = new AtomicQuestion(singleValue,answerType,keyword);
    atomicQuestion.description = description;
    atomicQuestion.indexed = (randomGenerator.nextInt(10) < 8)?false:true; // 80% not indexed

    return atomicQuestion;
  }

  public static ComplexQuestion generateOneComplexQuestion(String keyword, String description, int nestingLevel){
    ComplexQuestion complexQuestion = new ComplexQuestion(keyword);
    ArrayList<Question> subQuestions = generateListOfQuestions(nestingLevel,1);
    complexQuestion.setSubQuestions(subQuestions);
    complexQuestion.description = description;
    return complexQuestion;
  }

  public static ArrayList<Question> generateListOfQuestions(int nestingLevel, int minNumberOfQuestions){
    int numberOfQuestions = minNumberOfQuestions + randomGenerator.nextInt(20 - minNumberOfQuestions);
    ArrayList<Question> questions = new ArrayList<Question>();
    if(nestingLevel == 0){
      for(int i = 0; i < numberOfQuestions; ++i){
        AtomicQuestion atomicQuestion = generateOneAtomicQuestion("Question_" + nestingLevel + "_" + i, "This is the " + i + ". question");
        questions.add(atomicQuestion);
      }
      return questions;
    }
    else{
      int randomPosition = randomGenerator.nextInt(numberOfQuestions+1);
      ComplexQuestion complexSubQuestion = generateOneComplexQuestion("Question_"+nestingLevel+"_"+randomPosition,"This is the " + nestingLevel+"_" + randomPosition+". question",nestingLevel-1);

      for(int i = 1; i < numberOfQuestions ; ++i){
        if(i == randomPosition){
          questions.add(complexSubQuestion); // at least 1 complex question with correct nesting level
        }
        else{
          int complexOrAtomic = randomGenerator.nextInt(10);
          if(complexOrAtomic < 4 && nestingLevel > 0){ // 60% atomic 40% complex
            int randomNestingLevel =(nestingLevel == 1)?1:randomGenerator.nextInt(nestingLevel-1)+1;
            ComplexQuestion otherComplexQuestion =generateOneComplexQuestion("Question_"+randomNestingLevel+"_"+i,"This is the " + i + ". question",randomNestingLevel-1);
            questions.add(otherComplexQuestion);
          }
          else{
            AtomicQuestion atomicQuestion = generateOneAtomicQuestion("Question_"+nestingLevel+"_"+ i,"This is the " + i + ". question");
            questions.add(atomicQuestion);
          }
        }
      }
      return questions;
    }
  }
}
