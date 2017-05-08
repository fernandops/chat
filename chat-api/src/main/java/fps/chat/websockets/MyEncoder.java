package fps.chat.websockets;

import javax.websocket.EncodeException;
import javax.websocket.Encoder.Text;
import javax.websocket.EndpointConfig;

import fps.chat.domain.vo.MessageVO;

public class MyEncoder implements Text<MessageVO> {

	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(MessageVO object) throws EncodeException {
		return object.toJson();
	}

}
