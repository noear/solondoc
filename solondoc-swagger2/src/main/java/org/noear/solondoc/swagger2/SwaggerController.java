package org.noear.solondoc.swagger2;

import org.noear.snack.ONode;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

@Controller
public class SwaggerController {
    @Mapping(value = "/swagger-resources", produces = "application/json")
    public String swagger_resources() {
        return new ONode().asArray().build(n -> {
            n.addNew().set("name", "应用接口")
                    .set("location", "/v2/swagger.json")
                    .set("swaggerVersion", "2.0");
        }).toJson();
    }


    @Mapping("/v2/swagger.json")
    public String swagger_json(){
        return ONode.stringify(XPluginImp.swagger);
    }
}
