# android-mvp-tutorial
[Thirty-inch](https://github.com/grandcentrix/ThirtyInch), [Retrofit](https://github.com/square/retrofit), [GSON](https://github.com/google/gson), [RxJava](https://github.com/ReactiveX/RxAndroid) and [Requery](https://github.com/requery/requery) basic examples.


This repo contains ***'hello world'***-level examples of common android libraries with good project structure.
Each commit will have more libraries and examples than the previous commit. Increasing in difficulty but still as simple as `hello world` usage of each library.

-----

| Commit            | Description                                             |
| :------------- | :--------------------------------------------------------- |
| `e7146aa`      | MVP Structure with Thirty-inch with 1 Main Activity.       |
| `aad2d1b`      | Previous + With a fragment.                                |
| `96b6990`      | ... + HTTP call using Retrofit.                            |
| `f2a33c5`      | ... + Using GSON with Retrofit.                            |
| `90a8a09`      | ... + RxJava Retrofit.                                     |
| `379ded5`      | ... + Method references and managing RxJava disposables.   |
| `af30b50`      | ... + Setting up Requery and inserting data into SQLite utilizing RxJava.|


## MVP

- A graph of the relationship between a hypothetical LoginViewActivity, its interface, the BaseActivity (which every activity extends) and its interface. 

<img src="https://i.imgur.com/NyGn90t.png" width="1000">
