<p align="center">
  <a href="https://github.com/thaotram/uit.manga.reader" target="_blank" rel="noopener noreferrer">
    <img width="100" src="https://raw.githubusercontent.com/thaotram/uit.manga.reader/master/logo.png" alt="Logo">
  </a>
</p>

<p align="center">
  <a href="https://travis-ci.com/thaotram/uit.manga.reader"><img src="https://travis-ci.com/thaotram/uit.manga.reader.svg?branch=master" alt="Build Status"></a>
  <a href="https://github.com/thaotram/uit.manga.reader/issues"><img src="https://img.shields.io/github/issues/thaotram/uit.manga.reader.svg" alt="Issues Status"></a>
  <a href="https://github.com/thaotram/uit.manga.reader/network/members"><img src="https://img.shields.io/github/forks/thaotram/uit.manga.reader.svg" alt="Forks Status"></a>
  <a href="https://github.com/thaotram/uit.manga.reader/stargazers"><img src="https://img.shields.io/github/stars/thaotram/uit.manga.reader.svg" alt="Issues Status"></a>
  <a href="https://github.com/thaotram/uit.manga.reader/blob/master/LICENSE"><img src="https://img.shields.io/github/license/thaotram/uit.manga.reader.svg" alt="License Status"></a>
  <a href="https://github.com/thaotram/uit.manga.reader/releases"><img src="https://img.shields.io/github/languages/code-size/thaotram/uit.manga.reader.svg" alt="Code Size"></a>
  <a href="https://github.com/thaotram/uit.manga.reader/releases"><img src="https://img.shields.io/github/repo-size/thaotram/uit.manga.reader.svg" alt="Repo Size"></a>

  <h1 align="center"><a href="https://github.com/thaotram/uit.manga.reader">Ai Reader</a></h1>
</p>

Ai Reader is a open source android app, designed and built for end user reader your manga easier and free ads.

[<img src="https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png"
      alt="Download from Google Play"
      height="80">](https://play.google.com/store/apps/details?id=uit.manga.reader)

## Installation

Clone server repo

```
$ git clone https://github.com/phamhongphuc/uit.open.source.project
```
Make sure that `NodeJS 8.11.2` and yarn are installed in your computer.

```
yarn
yarn build
yarn start
```

Clone this repo

```
$ git clone https://github.com/thaotram/uit.manga.reader
```
In `app\src\main\res\values\strings.xml`
Set `server_url` to `localhost:3000`

Connect your phone. In your `SDK\platform-tools` directory run:
```
adb reverse tcp:3000 tcp:3000
```

## Contributors

This project exists thanks to all the people who contribute.

<p>
  <a href="https://github.com/thaotram"><img src="https://github.com/thaotram.png?size=40" alt="thaotram"></a>
</p>

## License

[MIT licensed](./LICENSE).
