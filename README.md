# wordlesolve

Wordleとその派生版を解くプログラムです

・Wordle.java
[Wordle](https://www.nytimes.com/games/wordle/index.html)を解くプログラムです。他のWordleみたいなの(例:Word Master,dordle)では単語が違うことがあり、解けない場合があります

・Primel.java
[Primel](https://converged.yt/primel/)(5桁の素数を当てるゲーム)を解くプログラムです。

・Pokemonwordle.java
[ポケモンWordle](https://wordle.mega-yadoran.jp/)を解くプログラムです。ダイパまでのものしか解けませんので、範囲を変えたい場合はpokemon1.txtをいじってください。

・Kentyou.java
[県庁Wordle](https://musemyuzu.github.io/prefectural_capitale/)を解くプログラムです。

## 実行方法
対象のファイルをコンパイル
候補数と次打つべき文字が表示されます。
"input return >>"と表示されるので、緑なら2、黄色なら1、灰色なら0となるように**空白なし**で打ってください。

例:Wordleで"AUDIO"と打ったら緑、黄色、灰色、灰色、灰色と帰ってきた時は"21000"と返してください
