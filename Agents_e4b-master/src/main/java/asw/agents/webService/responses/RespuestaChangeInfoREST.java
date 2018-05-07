package asw.agents.webService.responses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ChangeInfoResponse")
public class RespuestaChangeInfoREST {

	private String agent;
	private String message;

	public RespuestaChangeInfoREST() {
	}

	public RespuestaChangeInfoREST(String agente, String message) {
		super();
		this.agent = agente;
		this.message = message;
	}

	public String getAgent() {
		return agent;
	}

	@XmlElement
	public void setAgent(String agente) {
		this.agent = agente;
	}

	public String getMessage() {
		return message;
	}

	@XmlElement
	public void setMessage(String message) {
		this.message = message;
	}

}
