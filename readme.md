### Profile Matcher API

#### Installation

##### Locally

Clone the repository:
```sh
git clone https://github.com/oussamamessaoudi/profile_matcher.git
```

Build the project:
```sh
cd profile_matcher
./gradlew clean build
```

Run the application:
```sh
./gradlew bootRun --args='--spring.profiles.active=load-data'
```

#### Endpoint

##### To Beautify Response

- On Linux:
  ```sh
  sudo apt install jq
  ```

- On macOS:
  ```sh
  brew install jq
  ```

##### Get Client Config
```sh
curl http://localhost:8080/get_client_config/97983be2-98b7-11e7-90cf-082e5f28d836 | jq .
```