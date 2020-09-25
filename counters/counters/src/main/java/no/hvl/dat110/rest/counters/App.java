package no.hvl.dat110.rest.counters;

import com.google.gson.Gson;
import static spark.Spark.*;

public class App {

	static TodoList todolist = new TodoList();
	
	public static void main(String[] args) {

		if (args.length > 0)
			port(Integer.parseInt(args[0]));
		else
			port(8080);

		after((req, res) -> {
			res.type("application/json");
		});

		get("/todo", (req, res) -> new Gson().toJsonTree(todolist.getTodos()));
		get("/todo/:id", (req, res) -> new Gson().toJson(todolist.getTodo(req.params(":id"))));
		delete("/todo/:id", (req, res) -> {
			Todo todo = todolist.getTodo(req.params(":id"));
			String json = todo.toJson();
			todolist.deleteTodo(todo.getId());
			return json;
		});
		post("/todo", (req, res) -> {
			Todo todo = new Gson().fromJson(req.body(), Todo.class);
			todolist.addTodo(todo);
			return todo.toJson();
		});
		put("/todo/:id", (req, res) -> {
			Todo oldTodo = todolist.getTodo(req.params(":id"));
			Todo newTodo = new Gson().fromJson(req.body(), Todo.class);
			todolist.deleteTodo(oldTodo.getId());
			todolist.addTodo(newTodo);
			return newTodo.toJson();
		});
	}
}
