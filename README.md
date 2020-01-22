
<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Contributing](#contributing)
* [License](#license)

<!-- ABOUT THE PROJECT -->
## About The Project

This project is an example of an Azure DevOps CI/CD pipeline for the Java ecosystem.
For this particular example, we use Kotlin, but the steps would be similar regardles
of which JVM language you pick.

The _Continuous Integration_ pipeline includes:
* Unit Testing with Code Coverage (using jacoco)
* Static Analysis (with Detekt)
* Docker Image generation
* Docker Image scanning (with Anchore)
* Publishing to the Azure DevOps Maven-compatible repository
* Optional Sonarqube integration

The _Continuous Deployment_ pipeline includes:
* Automatic Deployment to Staging Namespace in AKS Cluster
* Manual Approval for Deployment to Production Namespace in AKS Cluster

### Built With

* Azure DevOps
* Gradle
* Kotlin
* JaCoCo
* Docker
* Anchore
* Kubernetes

<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Setup

1. [Create](https://docs.microsoft.com/en-us/azure/aks/kubernetes-walkthrough-portal) an AKS cluster. You can
 continue with the rest of the steps, while you wait for this step to complete.
2. [Create](https://docs.microsoft.com/en-us/azure/container-registry/container-registry-get-started-portal) a new
 Azure Container Registry. You can use the basic SKU to save cost.
3. Create an Azure DevOps Organization, if you don't already have one.
4. Create an Azure DevOps project.
5. Push the contents of this repository to your Azure DevOps project.
6. Setup the pipeline from the repository.  When you select where your code is located, Azure DevOps will
 automatically detect your pipeline in the repository.
7. [Create](https://docs.microsoft.com/en-us/azure/devops/pipelines/library/service-endpoints?view=azure-devops&tabs=yaml)
    Docker Registry Service Connection pointing to your ACR repository. You can name the connections whatever you
     would like but be sure to take note of what you named them.
8. [Setup](https://docs.microsoft.com/en-us/azure/devops/pipelines/process/environments-kubernetes?view=azure-devops)
    Kubernetes cluster resources for the staging and production environments.
    * Select the AKS cluster that you created previously.
    * Select a different namespace for each environment. You can create a new namespace or select an existing one at
     this point in the setup.
    * This step will automatically created the required Service Connection.
9. [Setup](https://docs.microsoft.com/en-us/azure/devops/pipelines/process/approvals?view=azure-devops) a manual approval check for the production environment.
10. Take note of the names of your Service Connections.
11. Configure pipeline variables in `azure-pipelines.yml`. The ones you likely want to change are marked with a todo
 comment describing what to put into the variable.

<!-- USAGE EXAMPLES -->
## Usage

When checking in a change to your Azure DevOps repo, the CI/CD pipeline will automatically run and deploy the latest
 code to staging. You will then have the option to manual approve a deployment to production.

## Developing

The following files are the most relevant for updating the pipeline for your own needs);
* `azure-pipelines.yml` - Azure DevOps Pipeline Definition
* `build.gradle` - Gradle build file
* `src/deploy/kubernetes` - Kubernetes manifest files
* `src/pipeline/templates/jobs` - Pipeline templates used in main file

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->
## License

Proprietary to the Government of Canada.

