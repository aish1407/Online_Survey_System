class Feedback
{
private int id;
private String name;
private String feedback;
private String suggestion;

public Feedback(){}
public Feedback(int id,String name,String feedback,String suggestion){
this.id=id;
this.name=name;
this.feedback=feedback;
this.suggestion=suggestion;
}
public void setId(int id){this.id=id;}
public int getId(){return id;}
public void setName(String name){this.name=name;}
public String getName(){return name;}
public void setFeedback(String feedback){this.feedback=feedback;}
public String getFeedback(){return feedback;}
public void setSuggestion(String suggestion){this.suggestion=suggestion;}
public String getSuggestion(){return suggestion;}
}