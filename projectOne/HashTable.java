package App;
public class HashTable {
  private HashNode hn;
  private class HashNode {
    String key;
    int value;
    HashNode next;

    public HashNode(String k, int v, HashNode n) {
      this.key = k;
      this.value = v;
      this.next = n;
    }

    public String getKey() {
      return key;
    }

    public int getValue() {
      return value;
    }
  }

  HashNode[] table = new HashNode[16];
  int count = 0;

  public HashTable(int key, String word) {
    hn = new HashNode(word, 1, null);
    hash(word);
  }

  public int set(String k) {
      int h = k.hashCode();
      int i = h & (table.length - 1);
      for(HashNode p = table[i]; p != null; p = p.next) {
        if(k.equals(p.key))
          return p.value;
      }
      return 0;
  }

  public void addOne(String k) {
    int h = k.hashCode();
    int i = h & (table.length - 1);
    for(HashNode p = table[i]; p != null; p = p.next) {
      if(k.equals(p.key))
        ++p.value;
      else {
        HashNode q = new HashNode(k, 1, table[i]);
        table[i] = q;
        //if(++count > .75 + table.length)
          //resize();
      }
    }
  }

  //public void resize() {}

  public long hash(String str) {
    return str2ascii(str);
  }

  public long str2ascii(String str) {
    String asciiStr = "";
    for (int i = 0; i < str.length(); i++)
      asciiStr = asciiStr + "" + (int) str.charAt(i);
    return Long.parseLong(asciiStr);
  }

}
