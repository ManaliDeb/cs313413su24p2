TestIterator Class:

setUp():
Using an array list is faster than using a linked list. However, it is more costly when moving around in the middle of a list, in which case a linked list is better.

testRemove():
"what happens if you use list.remove(Integer.valueOf(77))?"
The first instance of 77 would be removed.

TestList Class:

setUp():
Pretty much the same conclusion as the setUp method from the TestIterator class.

testRemoveObject():
"list.remove(5); // what does this method do?"
It removes the element at index 5
"list.remove(Integer.valueOf(5)); // what does this one do?"
It removes the value 5 the first time it occurs

TestPerformance Class:
I had to demote the version of Java I was using since the Gradle update didn't seem to sync, so it took a while to work!'

As the size went up, the time it took to add or remove elements stayed at 0 for the linked list, and increased drastically to 1438 ms for array lists. However, it was the opposite in terms of access time. The access time stayed the same for array lists despite the increase in size, however it took significantly longer for the linked list as the size increased.
This pretty much just solidified my understanding that array lists have better access times due to the nature of the structure and its random access, and linked lists are more cost efficient when adding and removing items.
