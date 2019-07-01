package br.com.polibots.beans;

import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.Context;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

public class Polibot {
	
	public static String perguntaCandidato(String candidato, String pergunta) {
		Context context = null;
		Conversation service = new Conversation("2018-02-16");
		service.setUsernameAndPassword("146f59b2-54d5-4d1c-aa7a-b83d7bbf8f50", "5xYGLOK4i4L2");
		
		// first message
		MessageOptions newMessageOptions = new MessageOptions.Builder()
		  .workspaceId("c738fbab-45a0-4637-940f-7fb42405dadf")
		  .input(new InputData.Builder(candidato).build())
		  .context(context)
		  .build();

		MessageResponse response = service.message(newMessageOptions).execute();

		// second message
		newMessageOptions = new MessageOptions.Builder()
		  .workspaceId("c738fbab-45a0-4637-940f-7fb42405dadf")
		  .input(new InputData.Builder(pergunta).build())
		  .context(response.getContext()) // output context from the first message
		  .build();

		response = service.message(newMessageOptions).execute();
		
		
		return response.getOutput().getText().toString().replace('[', ' ').replace(']', ' ');

	}
}