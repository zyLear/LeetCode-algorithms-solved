[TOC]

## Solution

---

#### Approach 1: List operation

**Algorithm**

1. Iterate over all the elements in ![\text{nums} ](./p__text{nums}_.png) 
2. If some number in ![\text{nums} ](./p__text{nums}_.png)  is new to array, append it
3. If some number is already in the array, remove it

```
class Solution {
  public int singleNumber(int[] nums) {
    List<Integer> no_duplicate_list = new ArrayList<>();

    for (int i : nums) {
      if (!no_duplicate_list.contains(i)) {
        no_duplicate_list.add(i);
      } else {
        no_duplicate_list.remove(new Integer(i));
      }
    }
    return no_duplicate_list.get(0);
  }
}
```

**Complexity Analysis**

* Time complexity : *O(n^2)*. We iterate through ![\text{nums} ](./p__text{nums}_.png) , taking *O(n)* time. We search the whole list to find whether there is duplicate number, taking *O(n)* time. Because search is in the `for` loop, so we have to multiply both time complexities which is *O(n^2)*.

* Space complexity : *O(n)*.  We need a list of size *n* to contain elements in ![\text{nums} ](./p__text{nums}_.png) .
<br />
<br />


---
#### Approach 2: Hash Table

**Algorithm**

We use hash table to avoid the *O(n)* time required for searching the elements.

1. Iterate through all elements in `nums` and set up key/value pair.
2. Return the element which appeared only once.

```
class Solution {
  public int singleNumber(int[] nums) {
    HashMap<Integer, Integer> hash_table = new HashMap<>();

    for (int i : nums) {
      hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
    }
    for (int i : nums) {
      if (hash_table.get(i) == 1) {
        return i;
      }
    }
    return 0;
  }
}
```

**Complexity Analysis**

* Time complexity : ![O(n\cdot1)=O(n) ](./p__O_n_cdot_1__=_O_n__.png) .  Time complexity of `for` loop is *O(n)*. Time complexity of hash table(dictionary in python) operation `pop` is *O(1)*.

* Space complexity : *O(n)*. The space required by ![hash\_table ](./p__hash_table_.png)  is equal to the number of elements in ![\text{nums} ](./p__text{nums}_.png) .
<br />
<br />


---
#### Approach 3: Math

**Concept**

*2 * (a + b + c) - (a + a + b + b + c) = c*

```
class Solution {
  public int singleNumber(int[] nums) {
    int sumOfSet = 0, sumOfNums = 0;
    Set<Integer> set = new HashSet();

    for (int num : nums) {
      if (!set.contains(num)) {
        set.add(num);
        sumOfSet += num;
      }
      sumOfNums += num;
    }
    return 2 * sumOfSet - sumOfNums;
  }
}
```

**Complexity Analysis**

* Time complexity : *O(n + n) = O(n)*. `sum` will call `next` to iterate through ![\text{nums} ](./p__text{nums}_.png) .
We can see it as `sum(list(i, for i in nums))` which means the time complexity is *O(n)* because of the number of elements(*n*) in ![\text{nums} ](./p__text{nums}_.png) .

* Space complexity : *O(n + n) = O(n)*. `set` needs space for the elements in `nums`
<br />
<br />


---
#### Approach 4: Bit Manipulation

**Concept**

- If we take XOR of zero and some bit, it will return that bit
    - ![a\oplus0=a ](./p__a_oplus_0_=_a_.png) 
- If we take XOR of two same bits, it will return 0
    - ![a\oplusa=0 ](./p__a_oplus_a_=_0_.png) 
- ![a\oplusb\oplusa=(a\oplusa)\oplusb=0\oplusb=b ](./p__a_oplus_b_oplus_a_=__a_oplus_a__oplus_b_=_0_oplus_b_=_b_.png) 

So we can XOR all bits together to find the unique number.

```
class Solution {
  public int singleNumber(int[] nums) {
    int a = 0;
    for (int i : nums) {
      a ^= i;
    }
    return a;
  }
}
```

**Complexity Analysis**

* Time complexity : *O(n)*.  We only iterate through ![\text{nums} ](./p__text{nums}_.png) , so the time complexity is the number of elements in ![\text{nums} ](./p__text{nums}_.png) .

* Space complexity : *O(1)*.