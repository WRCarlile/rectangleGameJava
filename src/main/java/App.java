import java.util.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");

      get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        String userName = request.queryParams("userName");

        model.put("template", "templates/welcome.vtl");
        return new ModelAndView(model, "templates/layout.vtl");
      }, new VelocityTemplateEngine());

      post("/home", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        String name = request.queryParams("userName");
        request.session().attribute("username", name);
        model.put("userName", name);
        model.put("template", "templates/home.vtl");

        return new ModelAndView(model, "templates/layout.vtl");
      }, new VelocityTemplateEngine());

      get("/detector", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        int length = Integer.parseInt(request.queryParams("length"));
        int width = Integer.parseInt(request.queryParams("width"));

        String name = request.session().attribute("username");

        Rectangle myRectangle = new Rectangle(length, width);
        model.put("results", myRectangle);

        model.put("template", "templates/detector.vtl");
        return new ModelAndView(model, "templates/layout.vtl");
      }, new VelocityTemplateEngine());
  }

  // public static Boolean methodName(String userInput) {
  //   return true;
  // }

}
