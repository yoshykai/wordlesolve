# wordlesolve

Wordleとその派生版を解くプログラムです

・Wordle.java<br>
[Wordle](https://www.nytimes.com/games/wordle/index.html)を解くプログラムです。他のWordleみたいなの(例:Word Master,dordle)では単語が違うことがあり、解けない場合があります

・Primel.java<br>
[Primel](https://converged.yt/primel/)(5桁の素数を当てるゲーム)を解くプログラムです。

・Pokemonwordle.java<br>
[ポケモンWordle](https://wordle.mega-yadoran.jp/)を解くプログラムです。ダイパまでのものしか解けませんので、範囲を変えたい場合はpokemon1.txtをいじってください。

・Kentyou.java<br>
[県庁Wordle](https://musemyuzu.github.io/prefectural_capitale/)を解くプログラムです。

・Dordle.java<br>
[Dordle](https://zaratustra.itch.io/dordle)を解くプログラムです。

・Quordle.java<br>
[Quordle](https://www.quordle.com/#/)を解くプログラムです。

## 実行方法
対象のファイルをコンパイルし実行<br>
候補数と次打つべき文字が表示されます。<br>
"input return >>"と表示されるので、緑なら2、黄色なら1、灰色なら0となるように**空白なし**で打ってください。

例:Wordleで緑、黄色、灰色、灰色、灰色と帰ってきた時は"21000"と返してください

**DordleとQuordleだけ入力方法が違います**<br>
2(4)つとも空白なしで入力してください。

例:Dordleで緑、黄色、灰色、灰色、灰色と黄色、灰色、灰色、灰色、緑色と帰ってきた時は"2100010002"と返してください
