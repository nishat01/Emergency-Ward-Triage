# Emergency-Ward-Triage

This is a Java-based program, done as an assignment for my second-year Data Structure and Algorithms class. Provided a few implementation details, I had to complete the system that triages patients in a hospital emergency ward. 

Patients are triaged according to both medical priority and wait time. Normally patients are seen in priority order. However, if there are patients who have waited longer than a specified time (maxWait), they are seen first, in order of their arrival.
I have used two location-aware priority queues implemented with min heaps: one based on medical priority and the other on arrival time, to produce the expected outcomes. To store the underlying binary trees of the heaps, ArrayLists are used. When a patient is removed from one queue they must also be removed from the other and location-aware priority queues can efficiently do this. The main operations i.e. adding a patient to the system when they arrive, and removing the next patient to be seen from the system when a physician becomes available etc. are O(log(n)), where n is the number of patients.
 
