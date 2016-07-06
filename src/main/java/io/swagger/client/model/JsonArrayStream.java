package io.swagger.client.model;

import io.swagger.annotations.ApiModel;

import org.dsa.iot.dslink.util.json.JsonArray;
import org.dsa.iot.dslink.util.json.JsonObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 
 **/
@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-08-31T13:09:15.165-07:00")
public class JsonArrayStream   {

    private JsonArray jsonArray;

    public JsonArrayStream() {
        jsonArray = new JsonArray();
    }
    
    public JsonArrayStream(JsonArray jsonArray) {
    	this.jsonArray = jsonArray;
    }

    public List<JsonObject> getJsonArray() {
        return new JsonArrayList(jsonArray);
    }
    
    public JsonArray getRawJsonArray() {
    	return jsonArray;
    }

    public void putJsonArray(JsonObject jo) {
        jsonArray.add(jo);
    }

    @Override
    public String toString()  {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < jsonArray.size(); i++) {
        JsonObject jo = jsonArray.get(i);
        sb.append("{\n  annotation: ").append(jo.get("annotation")).append("\n");
        sb.append("  value: ").append(jo.get("value")).append("\n");
        sb.append("  timestamp: ").append(jo.get("timestamp")).append("\n");
        sb.append("}\n");
    }
    return sb.toString();
    }
    
    
    private static class JsonArrayListIterator implements ListIterator<JsonObject> {
    	private ListIterator<Object> it;
    	
    	JsonArrayListIterator(ListIterator<Object> it) {
    		this.it = it;
    	}

		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public JsonObject next() {
			Object o = it.next();
			if (o instanceof JsonObject) return (JsonObject) o;
			JsonObject jo =  new JsonObject();
			jo.put("Object", o);
			return jo;
		}

		@Override
		public boolean hasPrevious() {
			return it.hasPrevious();
		}

		@Override
		public JsonObject previous() {
			Object o = it.previous();
			if (o instanceof JsonObject) return (JsonObject) o;
			JsonObject jo =  new JsonObject();
			jo.put("Object", o);
			return jo;
		}

		@Override
		public int nextIndex() {
			return it.nextIndex();
		}

		@Override
		public int previousIndex() {
			return it.previousIndex();
		}

		@Override
		public void remove() {
			it.remove();
			
		}

		@Override
		public void set(JsonObject e) {
			it.set(e);
			
		}

		@Override
		public void add(JsonObject e) {
			it.add(e);
			
		}
    }
    
    private static class JsonArrayIterator implements Iterator<JsonObject> {

    	private Iterator<Object> it;
    	
    	JsonArrayIterator(Iterator<Object> it) {
    		this.it = it;
    	}
    	
    	
		@Override
		public boolean hasNext() {
			return it.hasNext();
		}

		@Override
		public JsonObject next() {
			Object o = it.next();
			if (o instanceof JsonObject) return (JsonObject) o;
			JsonObject jo =  new JsonObject();
			jo.put("Object", o);
			return jo;
		}
    	
    }
    
    private static class JsonArrayList implements List<JsonObject> {
    	private JsonArray jsonArray;
    	
    	JsonArrayList(JsonArray ja) {
    		this.jsonArray = ja;
    	}
    	
		@Override
		public int size() {
			return jsonArray.size();
		}

		@Override
		public boolean isEmpty() {
			return jsonArray.getList().isEmpty();
		}

		@Override
		public boolean contains(Object o) {
			return jsonArray.getList().contains(o);
		}

		@Override
		public Iterator<JsonObject> iterator() {
			return new JsonArrayIterator(jsonArray.iterator());
		}

		@Override
		public Object[] toArray() {
			return jsonArray.getList().toArray();
		}

		@Override
		public <T> T[] toArray(T[] a) {
			return jsonArray.getList().toArray(a);
		}

		@Override
		public boolean add(JsonObject e) {
			jsonArray.add(e);
			return true;
		}

		@Override
		public boolean remove(Object o) {
			int ind = jsonArray.getList().indexOf(o);
			if (ind < 0) return false;
			jsonArray.remove(ind);
			return true;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			return jsonArray.getList().containsAll(c);
		}

		@Override
		public boolean addAll(Collection<? extends JsonObject> c) {
			return jsonArray.getList().addAll(c);
		}

		@Override
		public boolean addAll(int index, Collection<? extends JsonObject> c) {
			return jsonArray.getList().addAll(index, c);
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			return jsonArray.getList().removeAll(c);
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			return jsonArray.getList().retainAll(c);
		}

		@Override
		public void clear() {
			jsonArray.getList().clear();
			
		}

		@Override
		public JsonObject get(int index) {
			return jsonArray.get(index);
		}

		@Override
		public JsonObject set(int index, JsonObject element) {
			return jsonArray.set(index, element);
		}

		@Override
		public void add(int index, JsonObject element) {
			jsonArray.add(index, element);
			
		}

		@Override
		public JsonObject remove(int index) {
			return jsonArray.remove(index);
		}

		@Override
		public int indexOf(Object o) {
			return jsonArray.getList().indexOf(o);
		}

		@Override
		public int lastIndexOf(Object o) {
			return jsonArray.getList().lastIndexOf(o);
		}

		@Override
		public ListIterator<JsonObject> listIterator() {
			return new JsonArrayListIterator(jsonArray.getList().listIterator());
		}

		@Override
		public ListIterator<JsonObject> listIterator(int index) {
			return new JsonArrayListIterator(jsonArray.getList().listIterator(index));
		}

		@Override
		public List<JsonObject> subList(int fromIndex, int toIndex) {
			return new JsonArrayList(new JsonArray(jsonArray.getList().subList(fromIndex, toIndex)));
		}
    	
    }
}
