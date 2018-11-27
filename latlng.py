import csv
import time
import sys
from socket import timeout
from geopy.exc import GeocoderTimedOut
from geopy.geocoders import Nominatim
from datetime import datetime, timedelta

def main():
    geolocator = Nominatim(user_agent="SaveMeAndroidProject")

    data = []

    with open('{}'.format("data1.csv"), 'r', encoding='UTF-8') as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        for row in csv_reader:
            crime_date = datetime.strptime(row[13], '%b %d, %Y')
            today = datetime.now()
            delta = timedelta(days=180)
            two_months = today - delta
            if two_months > crime_date:
                print(crime_date)
                continue

            try:
                location = geolocator.geocode(
                    "{} {} {} {}".format(row[10].replace("X", "0"), row[11], row[12], "BC Canada"), exactly_one=True)
                time.sleep(1)
                print(location.latitude, location.longitude, crime_date)
            except AttributeError:
                continue
            except timeout:
                continue
            except GeocoderTimedOut:
                continue

            row.append(location.latitude)
            row.append(location.longitude)

            data.append(row)

    with open('{}'.format('data1.csv'), 'w', encoding='UTF-8', newline='') as csv_file:
        writer = csv.writer(csv_file, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)
        writer.writerows(data)


if __name__ == "__main__":
    main()
