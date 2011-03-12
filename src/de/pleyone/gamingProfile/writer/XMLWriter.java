package de.pleyone.gamingProfile.writer;

import de.pleyone.gamingProfile.GamingProfileTemplate;
import de.pleyone.gamingProfile.Question;
import de.pleyone.gamingProfile.AtomicQuestion;
import de.pleyone.gamingProfile.ComplexQuestion;

import java.util.Formatter;

/**
 * @author son87.lengoc@yahoo.de
 *         Created: 10.03.11 at 16:31
 */
public class XMLWriter implements Writer{
  public  String atomicQuestionToString(int numberOfTab,AtomicQuestion atomicQuestion){
    String tabString = "";
    for(int i = 0; i < numberOfTab ; ++i){
      tabString += "\t";
    }

    StringBuffer buffer = new StringBuffer();
    buffer.append(tabString);

    Formatter startTagFormat = new Formatter(buffer);
    startTagFormat.format("<%1$s description='%2$s' indexed='%3$b' answer_type='%4$s' type='%5$s' number_of_answer='%6$s'>\n",
                  atomicQuestion.getKeyword(), atomicQuestion.description, atomicQuestion.indexed, atomicQuestion.getAnswerType().toString(),"atomic", atomicQuestion.getNumberOfAnswer());

    buffer.append(tabString);
    buffer.append("\tNULL\n");

    buffer.append(tabString);
    buffer.append("</" + atomicQuestion.getKeyword()+ ">\n");

    return buffer.toString();
  }

  public String complexQuestionToString(int numberOfTab,ComplexQuestion complexQuestion){
    String tabString = "";
    for(int i = 0; i < numberOfTab ; ++i){
      tabString += "\t";
    }

    StringBuffer buffer = new StringBuffer();
    buffer.append(tabString);

    Formatter startTagFormat = new Formatter(buffer);
    startTagFormat.format("<%1$s description='%2$s' type='%3$s'>\n", complexQuestion.getKeyword(), complexQuestion.description, "complex");

    ++numberOfTab;
    for( Question subQuestion : complexQuestion.getSubQuestions()){
      buffer.append(questionToString(numberOfTab, subQuestion));
    }

    buffer.append(tabString);
    buffer.append("</" + complexQuestion.getKeyword()+ ">\n");

    return buffer.toString();
  }

  public String questionToString(int numOfTab,Question question){
    if(question.isAtomic()){
      return atomicQuestionToString(numOfTab,(AtomicQuestion) question);
    }
    else{
      return complexQuestionToString(numOfTab,(ComplexQuestion) question);
    }
  };

  public String questionToString(Question question){
    return questionToString(0,question);
  }

  public String gamingProfileTemplateToString(GamingProfileTemplate gamingProfileTemplate){
    StringBuffer buffer = new StringBuffer();
    buffer.append("<GamingProfileTemplate>\n");
    for(Question question: gamingProfileTemplate.questions){
      buffer.append(questionToString(1,question));
    }
    buffer.append("</GamingProfileTemplate>");

    return buffer.toString();
  }
}
