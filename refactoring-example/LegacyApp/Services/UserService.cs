using System;

namespace LegacyApp
{
    public class UserService
    {
        //AddUser_ShouldAddUserCorrectly
        //AddUser_ShouldFail_IncorrectEmail

        public bool AddUser(string firstName, string lastName, string email, DateTime dateOfBirth, int clientId)
        {
            
            if (!checkArguments(firstName, lastName, email, dateOfBirth))
            {
                return false;
            }

            var clientRepository = new ClientRepository();
            var client = clientRepository.GetById(clientId);

            var user = new User
            {
                Client = client,
                DateOfBirth = dateOfBirth,
                EmailAddress = email,
                FirstName = firstName,
                LastName = lastName
            };

            switch (client.Name) {
                case "VeryImportantClient":            
                    handleVeryImportantClient(user);
                    break;
                case "ImportantClient":
                    handleImportantClient(user);
                    break;
                default:
                    handleDefault(user);
                    break;
            }


            if (!checkLimit(user))
            {
                return false;
            }

            UserDataAccess.AddUser(user);
            return true;
        }



        public bool checkArguments(string firstname, string lastName, string email, DateTime dateOfBirth)
        {
            bool valid = true;
            if(String.IsNullOrEmpty(firstname) || String.IsNullOrEmpty(lastName) || !checkEmail(email) || !checkAge(dateOfBirth))
            {
                valid = false;
            }

            return valid;
        }

        public bool checkEmail(string email)
        {
            bool valid = true;
            if (!email.Contains("@") && !email.Contains("."))
            {
                valid = false;
            }
            return valid;
        }

        public bool checkAge(DateTime dateOfBirth)
        {
            bool valid = true;
            var now = DateTime.Now;
            int age = now.Year - dateOfBirth.Year;
            if (now.Month < dateOfBirth.Month || (now.Month == dateOfBirth.Month && now.Day < dateOfBirth.Day))
            { 
                age--; 
            }

            if (age < 21)
            {
                valid = false;
            }

            return valid;
        }

        public void handleVeryImportantClient(User user)
        {
            user.HasCreditLimit = false;
        }

        public void handleImportantClient(User user)
        {
            using (var userCreditService = new UserCreditService())
            {
                int creditLimit = userCreditService.GetCreditLimit(user.FirstName, user.LastName, user.DateOfBirth);
                creditLimit = creditLimit * 2;
                user.CreditLimit = creditLimit;
            }
        }

        public void handleDefault(User user)
        {
            user.HasCreditLimit = true;
            using (var userCreditService = new UserCreditService())
            {
                int creditLimit = userCreditService.GetCreditLimit(user.FirstName, user.LastName, user.DateOfBirth);
                user.CreditLimit = creditLimit;
            }
        }

        public bool checkLimit(User user)
        {
            bool valid = true;
            if (user.HasCreditLimit && user.CreditLimit < 500)
            {
                valid = false;
            }
            return valid;
        }

    }
}
