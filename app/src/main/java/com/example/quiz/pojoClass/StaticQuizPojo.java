package com.example.quiz.pojoClass;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class StaticQuizPojo{

	@SerializedName("“question”")
	private List<QuestionItem> question;

	public void setQuestions(List<QuestionItem> question){
		this.question = question;
	}

	public List<QuestionItem> getQuestions(){
		return question;
	}

	@Override
 	public String toString(){
		return 
			"StaticQuizPojo{" + 
			"“question” = '" + question + '\'' + 
			"}";
		}
}