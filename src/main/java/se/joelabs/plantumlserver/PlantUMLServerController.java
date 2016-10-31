package se.joelabs.plantumlserver;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PlantUMLServerController {
  @ResponseBody
  @RequestMapping(value = "/uml", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
  public byte[] generateImageFromUmlScript(@RequestParam(value = "script", defaultValue = "@startuml;actor Kaka;@enduml") String script) throws IOException {
    SourceStringReader reader = new SourceStringReader(script.replace(';','\n'));
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    reader.generateImage(bos, new FileFormatOption(FileFormat.PNG, false));
    return bos.toByteArray();
  }
}
