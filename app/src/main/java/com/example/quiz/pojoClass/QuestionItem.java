package com.example.quiz.pojoClass;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class QuestionItem{

	@SerializedName("“questionType”")
	private String questionType;

	@SerializedName("“category”")
	private String category;

	@SerializedName("“questionId”")
	private String questionId;

	@SerializedName("“answer”")
	private List<String> answer;

	@SerializedName("“answerType”")
	private String answerType;

	@SerializedName("“question”")
	private String question;

	@SerializedName("“difficulty”")
	private String difficulty;

	@SerializedName("“binaryFilePath”")
	private String binaryFilePath;

	public void setQuestionType(String questionType){
		this.questionType = questionType;
	}

	public String getQuestionType(){
		return questionType;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setQuestionId(String questionId){
		this.questionId = questionId;
	}

	public String getQuestionId(){
		return questionId;
	}

	public void setAnswer(List<String> answer){
		this.answer = answer;
	}

	public List<String> getAnswer(){
		return answer;
	}

	public void setAnswerType(String answerType){
		this.answerType = answerType;
	}

	public String getAnswerType(){
		return answerType;
	}

	public void setQuestion(String question){
		this.question = question;
	}

	public String getQuestion(){
		return question;
	}

	public void setDifficulty(String difficulty){
		this.difficulty = difficulty;
	}

	public String getDifficulty(){
		return difficulty;
	}

	public void setBinaryFilePath(String binaryFilePath){
		this.binaryFilePath = binaryFilePath;
	}

	public String getBinaryFilePath(){
		return binaryFilePath;
	}

	@Override
 	public String toString(){
		return 
			"QuestionItem{" + 
			"“questionType” = '" + questionType + '\'' + 
			",“category” = '" + category + '\'' + 
			",“questionId” = '" + questionId + '\'' + 
			",“answer” = '" + answer + '\'' + 
			",“answerType” = '" + answerType + '\'' + 
			",“question” = '" + question + '\'' + 
			",“difficulty” = '" + difficulty + '\'' + 
			",“binaryFilePath” = '" + binaryFilePath + '\'' + 
			"}";
		}
}